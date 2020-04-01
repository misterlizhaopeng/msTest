package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //标记为eureka服务
public class Eureka_A {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_A.class, args);
    }
}