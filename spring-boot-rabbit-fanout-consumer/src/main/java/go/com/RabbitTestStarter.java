package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RabbitTestStarter {
    public static void main(String[] args) {
        SpringApplication.run(RabbitTestStarter.class,args);
    }
}
