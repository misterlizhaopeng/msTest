package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
//@EnableEurekaClient
public class ProviderUser {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUser.class, args);
    }
}
