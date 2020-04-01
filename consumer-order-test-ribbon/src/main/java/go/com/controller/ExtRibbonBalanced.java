package go.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ExtRibbonBalanced {
    private int reqCount;

    @Autowired
    private RestTemplate  restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/helloTest")
    public String getMethod(){
        String url = serviceUrl();
        String forObject = restTemplate.getForObject(url+"/testMethod", String.class);
        return forObject;
    }

    /**
     * 模拟ribbon的负载均衡策略
     * @return
     */
    private  String serviceUrl(){
        List<ServiceInstance> instances =
                discoveryClient.getInstances("PROVIDER-USER3");
        if (instances==null ||instances.size()<=0)
        {
            return null;
        }

        //获取服务器的数量
        int size = instances.size();
        int serviceIndex = reqCount % size;
        reqCount++;
        //返回指定的服务
        return instances.get(serviceIndex).getUri().toString();
    }
}
