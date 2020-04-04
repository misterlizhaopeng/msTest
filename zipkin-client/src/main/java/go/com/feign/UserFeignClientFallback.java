package go.com.feign;

import go.com.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback  implements  UserFeignClient{
    @Override
    public String testpro(String id) {
        return "容错机制：UserFeignClientFallback-testpro(String id)";
    }

    @Override
    public User hello(String id) {

        return new User(-1, "-1-hello-容错");
    }

    @Override
    public User c(User user) {
        return new User(-1, "-1-c-容错");
    }
}
