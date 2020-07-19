package go.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
public class TestConfigController {

    @Value("${constant}")  // 来自config server
    private String t;
    @Value("${b}")
    private String b;
    @Value("${ip}")
    private String ip;


    @GetMapping("/getVal/{id}")
    public String getVal(@PathVariable("id") String id) {
        return "configServer->" + t + ";Input->" + id + ";b->" + b + ",ip->" + ip;
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
