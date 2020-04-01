package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@ImportResource({ "classpath:bytetcc-supports-springcloud.xml" })
@SpringBootApplication
public class ProviderUser {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUser.class, args);
    }
}
