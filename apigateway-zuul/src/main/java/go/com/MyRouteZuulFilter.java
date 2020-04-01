package go.com;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * 什么是zuul的过滤器？ 是在路由的几个情况下（pre,route,post,error）进行处理当前的动作
 *
 */
@Component
public class MyRouteZuulFilter extends  ZuulFilter {

    /**
     * 类型包含下面四个
     * pre :代表路由执行之前执行
     * route: 代表路由代理的时候执行
     * post: 代表route或者error执行之后执行
     * error: 代表出错的时候执行
     * @return
     */
    @Override
    public String filterType() {
        return "route";
    }

    /**
     * 过滤器是一个链式的执行顺序，如何执行该链式的过滤器呢？
     * javaee中的过滤器是按照配置先后的顺序执行的
     * zuul是通过数字执行的，数字越小越先被执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 表示是否执行这个过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 具体的执行代码
     *
     * @return
     */
    @Override
    public Object run() {
        System.out.println("代码执行了...route");
        return null;
    }
}
