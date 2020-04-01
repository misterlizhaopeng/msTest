package go.com.controller;

import go.com.conf.RedisService;
import go.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {


    @Resource
    private RedisService redisService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello/{id}")
    public User hello(@PathVariable("id") String id) {
        String ccc = redisService.get("ccc");
        System.out.println(ccc);


        return new User(Integer.parseInt(id), port);
    }


    @PostMapping("/hello-user")
    public User a(@RequestBody User user) {


        System.out.println("---------->ok,port:" + port);
        return new User(user.getId(), port);
    }


}
