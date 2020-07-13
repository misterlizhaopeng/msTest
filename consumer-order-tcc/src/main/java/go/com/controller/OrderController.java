package go.com.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import go.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Value("${user.url}")
    private String USER_URL;

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/hello/{id}")
    public User hello(@PathVariable("id") String id) {
        InstanceInfo fromEureka = eurekaClient.getNextServerFromEureka("provider-user", false);
        String pageUrl = fromEureka.getHomePageUrl();

        System.out.println("hostname--->" + fromEureka.getHostName());
        System.out.println("port--->" + fromEureka.getPort());
        System.out.println("instanceId--->" + fromEureka.getInstanceId());
        System.out.println("ipaddrs--->" + fromEureka.getIPAddr());
        System.out.println("--->" + pageUrl);

        //之所以把pageUrl换成如下的拼接的url，个人感觉在分布式系统中，应该用ip地址更清楚一些，所以进行了拼接
        String url = "http://" + fromEureka.getIPAddr() + ":" + fromEureka.getPort() + "/hello/" + id;
        System.out.println("------>url:" + url);
//        return restTemplate.getForObject(url, User.class);
        return null;
    }

    /**
     * ribbon 测试
     *
     * @param id
     * @return
     */
    @GetMapping("/hello2/{id}")
    public User hello2(@PathVariable("id") String id) {
        System.out.println(id);
        return null;
    }


    @GetMapping("/test")
    public String tst() {
        //选择指定的服务进行负载测试
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-user");
        System.out.println("serviceId:" + serviceInstance.getServiceId() + ",host:" + serviceInstance.getHost() + ",port:" + serviceInstance.getPort());


        return "";
    }

}
