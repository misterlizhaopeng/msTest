package go.com.controller;

import go.com.feign.UserFeignClient;
import go.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestUController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value="/testPro/{id}",method = RequestMethod.GET)
    String testpro(@PathVariable("id") String id){
        return userFeignClient.testpro(id);
    }

    @GetMapping("/hello/{id}")
    User hello(@PathVariable("id") String id){
        return userFeignClient.hello(id);
    }

    @PostMapping("/hello-user")
    User c(@RequestBody User user){
        return userFeignClient.c(user);
    }
}
