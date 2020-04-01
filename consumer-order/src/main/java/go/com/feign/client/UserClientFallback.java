package go.com.feign.client;

import go.com.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * feign 启用hystrix，为了在客户端实现服务的降级
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public User hello(String id) {
        User user = new User();
        user.setId(-100);
        user.setDate(new Date());
        return user;
    }

    @Override
    public User c(User user) {
        user.setId(-120);
        user.setDate(new Date());
        return user;
    }
}
