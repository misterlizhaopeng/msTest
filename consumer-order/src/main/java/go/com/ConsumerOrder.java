package go.com;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.ribbon.FeignLoadBalancer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.DefaultServerIntrospector;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableCircuitBreaker
@EnableHystrix
//@EnableDiscoveryClient
public class ConsumerOrder {
    /**
     * 相当于xml中的bean
     * 注入一个RestTemplate
     *
     * @return
     */
//    @Bean
    //@LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

//    @Bean
//    public FeignLoadBalancer feignLoadBalancer(){
//        return new FeignLoadBalancer(new BaseLoadBalancer(),new DefaultClientConfigImpl(), new DefaultServerIntrospector());
//    }



    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder.class, args);
    }
}
