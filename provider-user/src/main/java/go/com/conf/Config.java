package go.com.conf;

import go.com.model.PersonBeanNameAware;
import go.com.model.UserInfoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
//    @Bean
//    public PersonBeanNameAware personBeanNameAware(){
//       return  new PersonBeanNameAware();
//    }


    @Bean(initMethod = "init",destroyMethod = "destroy")
    public UserInfoBean userInfoBean (){
        return new UserInfoBean();
    }
}
