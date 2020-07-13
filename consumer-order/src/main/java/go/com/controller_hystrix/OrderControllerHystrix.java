package go.com.controller_hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import go.com.feign.client.UserClient;
import go.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class OrderControllerHystrix {
    @Autowired
    private UserClient userClient;

    @GetMapping("/hello_feign_hystrix/{id}")
    public User hello_feign(@PathVariable("id") String id) {
        System.out.println("1-invoke-[hello_feign_hystrix]-name:"+Thread.currentThread().getName());
        return testUrl(id);
    }

    private  User testUrl(String id){
        User hello = userClient.hello(id);
        System.out.println("3-invoke-[testUrl]-name:"+Thread.currentThread().getName());
        return hello;
    }

    @HystrixCommand(fallbackMethod = "back_b",commandProperties ={@HystrixProperty(name="execution.isolation.strategy",value="SEMAPHORE")} )//此处的回调是在另一个线程执行的，如果要在同一个线程执行，则需要添加注解@HystrixCommand属性commandProperties
    @RequestMapping(value = "/hello_user_hystrix", method = RequestMethod.GET)
    public User b(User user)
    {

        System.out.println("invoke-[hello_user_hystrix]-name:"+Thread.currentThread().getName());
        int i=1/0;

        return user;
        //  return userClient.c(user);
    }

    public User back_b(User user) {
        System.out.println("callback-[back_b]-name:"+Thread.currentThread().getName());
        user.setId(-101);
        user.setDate(new Date());
        return user;
    }
}
