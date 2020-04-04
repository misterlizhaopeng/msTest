package go.com.feign;

import go.com.ConfigurationLoad;
import go.com.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "provider-user",configuration = ConfigurationLoad.class, fallbackFactory = UserFeignClientFallbackFactory.class)//fallback = UserFeignClientFallback.class
public interface UserFeignClient {

    @RequestMapping(value = "/testPro/{id}", method = RequestMethod.GET)
    String testpro(@PathVariable("id") String id);

    @GetMapping("/hello/{id}")
    User hello(@PathVariable("id") String id);

    @PostMapping("/hello-user")
    User c(@RequestBody User user);


}
