package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
//@EnableCircuitBreaker
public class ConsumerOrderRibbon {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderRibbon.class, args);
    }
}