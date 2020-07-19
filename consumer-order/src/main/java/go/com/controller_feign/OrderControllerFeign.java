package go.com.controller_feign;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import go.com.feign.client.UserClient;
import go.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.ribbon.FeignLoadBalancer;
import org.springframework.cloud.netflix.feign.ribbon.LoadBalancerFeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderControllerFeign {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserClient userClient;

    @GetMapping("/hello_feign/{id}")
    public User hello_feign(@PathVariable("id") String id) {
        if (id.equals("1")) {
            throw new RuntimeException("异常,gogog");
        }
        if (id.equals("2")) {
            int i = 1 / 0;
        }

        if (id.equals("3")) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("port:" + port);
        return userClient.hello(id);
    }

    @RequestMapping(value = "/hello-user", method = RequestMethod.GET)
    public User b(User user) {
        return userClient.c(user);
    }


    /**
     * import org.springframework.cloud.client.ServiceInstance;
     * import org.springframework.cloud.client.discovery.DiscoveryClient;
     *
     * 获取每一个服务下面实例
     * 测试时，可以使用多个端口启动服务实例
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/serviceurl")
    public Map<String, List<ServiceInstance>> serviceUrl() {
        Map<String, List<ServiceInstance>> msl = new HashMap<>();
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> sis = discoveryClient.getInstances(service);
            msl.put(service, sis);
        }
        return msl;


    }
}