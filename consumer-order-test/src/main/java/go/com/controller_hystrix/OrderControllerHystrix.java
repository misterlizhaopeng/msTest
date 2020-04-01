package go.com.controller_hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import go.com.feign.client.UserClient;
import go.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderControllerHystrix {
    @Autowired
    private UserClient userClient;

    @GetMapping("/hello_feign_hystrix/{id}")
    public User hello_feign(@PathVariable("id") String id) {
        return userClient.hello(id);
    }

    @HystrixCommand(fallbackMethod = "back_b")//此处的回调是在另一个线程执行的，如果要在同一个线程执行，则需要添加注解@HystrixCommand属性commandProperties
    @RequestMapping(value = "/hello_user_hystrix", method = RequestMethod.GET)
    public User b(User user)
    {
        return userClient.c(user);
    }

    public User back_b(User user) {
        return new User();
    }
}
