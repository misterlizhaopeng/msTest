package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */
@SpringBootApplication
//@EnableEurekaClient
//@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderUser {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUser.class, args);
    }
}