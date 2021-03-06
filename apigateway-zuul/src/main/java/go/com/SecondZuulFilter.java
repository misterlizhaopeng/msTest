package go.com;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
@Component
public class SecondZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }


    @Override
    public boolean shouldFilter() {
        //通过对象RequestContext对象可以拿到参数
        RequestContext ctx =RequestContext.getCurrentContext();
        String ticket = (String)ctx.get("ticket");
        return false;

    }

    @Override
    public Object run() throws ZuulException {
        //通过对象RequestContext对象可以拿到参数
        RequestContext ctx =RequestContext.getCurrentContext();
        String ticket = (String)ctx.get("ticket");
        System.out.println("第2个过滤器接收到参数ticket的值为："+ticket);
        return null;
    }
}
