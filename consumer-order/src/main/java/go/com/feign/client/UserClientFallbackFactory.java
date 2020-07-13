package go.com.feign.client;

import feign.hystrix.FallbackFactory;
import go.com.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User hello(String id) {
                System.out.println("2-invoke-[UserClientFallbackFactory->hello]-name:"+Thread.currentThread().getName());
                User user = new User();
                user.setId(-1);
                user.setDate(new Date());
                return user;
            }

            @Override
            public User c(User user) {
                user.setId(-120);
                user.setDate(new Date());
                return user;
            }
        };
    }
}
