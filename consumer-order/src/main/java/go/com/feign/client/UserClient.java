package go.com.feign.client;

import go.com.ConfigurationLoad;
import go.com.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
//configuration = ConfigurationLoad.class,
//@FeignClient(value = "provider-user3",  fallback = UserClientFallback.class)//
@FeignClient(value = "provider-user", configuration = ConfigurationLoad.class, fallbackFactory = UserClientFallbackFactory.class)//
//value 表示eureka中的服务Application名称
public interface UserClient {

    @GetMapping("/hello/{id}")
    User hello(@PathVariable("id") String id);

    /**
     * 注意：
     * 1.传递复杂类型的数据，post请求才可以传递，且参数中必须添加注解l @RequestBody
     * 2.RequestMapping(value = "/hello-user",method = RequestMethod.POST)  //√ (这种写法可以，下面的写法PostMapping也可以)
     * 3.feign 是声明式的客户端负载均衡，包括（熔断和降级功能），接口只关注请求中的url和请求方法，不关注方法名称的写法，比如下面的方法名称c
     *
     * @param user
     * @return
     */
//    @GetMapping("/hello-user")  //
//    @RequestMapping(value = "/hello-user",method = RequestMethod.POST)  //√ (这种写法可以，下面的写法PostMapping也可以)
    @PostMapping("/hello-user")
    User c(@RequestBody User user);
}