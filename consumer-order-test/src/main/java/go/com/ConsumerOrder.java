package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import java.util.HashMap;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerOrder {
    /**
     * 相当于xml中的bean
     * 注入一个RestTemplate
     *
     * @return
     */
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

//    @Bean
//    public FeignLoadBalancer feignLoadBalancer(){
//        return new FeignLoadBalancer(new BaseLoadBalancer(),new DefaultClientConfigImpl(), new DefaultServerIntrospector());
//    }



    public static void main(String[] args) {


        HashMap hashMap =new HashMap();
        hashMap.put("", "");

        SpringApplication.run(ConsumerOrder.class, args);
    }
}
