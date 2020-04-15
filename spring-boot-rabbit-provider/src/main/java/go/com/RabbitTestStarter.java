package go.com;

import go.com.queue.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RabbitTestStarter {
    public static void main(String[] args) {
        SpringApplication.run(RabbitTestStarter.class,args);
    }


    @Autowired
    private Sender sender;

    @GetMapping("/hello/rabbittest/{msg}")
    public String rabbittest(@PathVariable("msg") String msg){
        sender.send(msg);//"hello rabbit!~"
        return "ok";
    }
}
