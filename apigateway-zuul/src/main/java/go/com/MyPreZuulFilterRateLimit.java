package go.com;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SystemPublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;

// 在Zuul上实现微服务粒度的限流，找出不同的微服务，或者请求地址，进行限流；
@Component
@RefreshScope
public class MyPreZuulFilterRateLimit extends ZuulFilter {


    private Map<String, RateLimiter> map = Maps.newConcurrentMap();

    @Autowired
    private SystemPublicMetrics systemPublicMetrics;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;//也可以写字符串，这只不过是一个常量值
    }

    @Override
    public int filterOrder() {

        // 这边的order一定要大于org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter的order
        // 也就是要大于5
        // 否则，RequestContext.getCurrentContext() 里拿不到 serviceId 等数据。
        // 该值表示当前过滤器最后执行
        return Ordered.LOWEST_PRECEDENCE;//lowest_precedence
    }

    /**
     * 表示是否执行当前过滤器，true表示可以执行，false不可执行
     * 这里可以考虑弄个限流开启的开关，开启限流返回true，关闭限流返回false;
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {


        // 这里可以考虑弄个限流开启的开关，开启限流返回true，关闭限流返回false，你懂的。
        Collection<Metric<?>> metrics = systemPublicMetrics.metrics();
        Optional<Metric<?>> freeMemoryMetric = metrics.stream()
                .filter(t -> "mem.free".equals(t.getName()))
                .findFirst();

        // 如果不存在这个指标，稳妥起见，返回true，开启限流
        if (!freeMemoryMetric.isPresent()) {
            return true;
        }

        long freeMemory = freeMemoryMetric.get()
                .getValue()
                .longValue();

        // 如果可用内存小于1000000KB，开启流控
        return freeMemory < 1000000L;
    }


    /**
     * 具体的执行代码
     *
     * @return
     */
    @Override
    public Object run() {

        try {
            //多个过滤器传递参数使用到了RequestContext对象；
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletResponse response = ctx.getResponse();

            String key = null;
            // 对于service格式的路由，走RibbonRoutingFilter
            // 请求不同的服务，serviceId的值会是不同服务的名称
            String serviceId = (String) ctx.get(SERVICE_ID_KEY);
            if (serviceId != null) {
                key = serviceId;
                map.putIfAbsent(serviceId, RateLimiter.create(2));
            } else {
                //如果压根不走RibbonRoutingFilter，则认为是URL格式的路由
                // 对于URL格式的路由，走SimpleHostRoutingFilter
                URL routeHost = ctx.getRouteHost();
                if (routeHost != null) {
                    String url = routeHost.toString();
                    key = url;
                    map.putIfAbsent(url, RateLimiter.create(2000.0));
                }
            }

            RateLimiter rateLimiter = map.get(key);
            if (!rateLimiter.tryAcquire()) {
                HttpStatus httpStatus = HttpStatus.TOO_MANY_REQUESTS;
                response.setContentType(MediaType.TEXT_PLAIN_VALUE);
                response.setStatus(httpStatus.value());
                response.getWriter().append(httpStatus.getReasonPhrase());
                ctx.setSendZuulResponse(false);
                throw new ZuulException(
                        httpStatus.getReasonPhrase(),
                        httpStatus.value(),
                        httpStatus.getReasonPhrase()
                );
            }

        } catch (Exception ex) {
            ReflectionUtils.rethrowRuntimeException(ex);
        }


        return null;
    }
}
