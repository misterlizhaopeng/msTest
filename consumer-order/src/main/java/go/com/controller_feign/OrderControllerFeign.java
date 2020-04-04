package go.com.controller_feign;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import go.com.feign.client.UserClient;
import go.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.ribbon.FeignLoadBalancer;
import org.springframework.cloud.netflix.feign.ribbon.LoadBalancerFeignClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderControllerFeign {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserClient userClient;

    @GetMapping("/hello_feign/{id}")
    public User hello_feign(@PathVariable("id") String id)
    {
        System.out.println("port:"+port);
        return userClient.hello(id);
    }

    @RequestMapping(value = "/hello-user", method = RequestMethod.GET)
    public User b(User user) {
        return userClient.c(user);
    }
}