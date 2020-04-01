package go.com;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;


/**
 * 什么是zuul的过滤器？ 是在路由的几个情况下（pre,route,post,error）进行处理当前的动作，详细看下面a->f的总结：
 *
 *  a.对于filterType来说，有一个执行顺序：pre->route->[执行调用请求，执行完之后]->post，对于error来说，在pre、route阶段都有可能存在error，如果
 *      存在，执行玩error之后，再执行post，不论是否出现error，执行完post之后，响应浏览器；
 *  b.对于filterOrder来说，数据越小优先级别越高，比如0,1，2,3,4等等；
 *  c.对于shouldFilter来说，表示当前的过滤式是否执行的意思；
 *  d.对于run来说，当前过滤器的执行方法，有意思的是该方法的返回值可忽略，也就是说无意义；
 *  e.如果在多个可以执行的过滤器来说，filterType决定的过滤器决定权高于filterOrder，也就是先考率过滤器的类型，然后在考虑过滤器的执行顺序
 *  f.对于多个可以执行的过滤器来说，上一个过滤器可以向下面的过滤器通过对象RequestContext传递参数，这样可以可以实现过滤器链上的过滤器的执行逻辑；
 *
 *
 */
@Component
public class MyPreZuulFilter  extends  ZuulFilter {

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
        return FilterConstants.PRE_TYPE;//也可以下字符串，这只不过是一个常量值
//        return "pre";
    }

    /**
     * 过滤器是一个【链式】的执行顺序，如何执行该链式的过滤器呢？
     * zuul是通过数字执行的，数字越小越先被执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 表示是否执行当前过滤器，true表示可以执行，false不可执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的执行代码
     *
     * @return
     */
    @Override
    public Object run() {

        //多个过滤器传递参数使用到了RequestContext对象；
        RequestContext ctx= RequestContext.getCurrentContext();
        ctx.set("ticket", "ticket");//在过滤器链上添加参数ticket，可以用于过滤器链上剩下的可以执行过滤器的逻辑控制；

        //请求控制 start

        //  拿到请求信息
        HttpServletRequest request = ctx.getRequest();
        String pm = request.getParameter("pm");
        System.out.println("请求的参数pm的值为："+pm);
        //获取请求头的token信息
        String token = request.getHeader("ticket");
        if (token==null ||token.equals(""))
        {
            //表示过滤器链到此结束，此处为false不能组织下一个过滤器，只是在过滤器链上设置了false的值，剩下的过滤器可以先拿到该值再控制是否执行
            ctx.setSendZuulResponse(false);
            //响应状态码
            ctx.setResponseStatusCode(401);
            //响应的内容
//            ctx.setResponseBody("请求无效...abcD");
            //ctx.setResponseDataStream(new ByteArrayInputStream("{\"msg\":\" invalid request，请求无效，请重新登录！\"}".getBytes()));
            ctx.getResponse().setCharacterEncoding("UTF-8");// 解决下面setResponseBody响应到浏览器中文乱码的问题
            ctx.setResponseBody("{\"msg\":\" invalid request，请求无效，请重新登录！\"}");

        }

        //请求控制 end


        System.out.println("代码执行了...pre");
        return null;//对于返回值：返回的内容对于现在的框架没有意义，所以可返回，也可以不用返回
    }
}
