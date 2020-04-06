package go.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class AppConfig {
    // 解决requestContext.setResponseBody("") 乱码的问题，此bean不起作用；
//    @Bean
//    public CommonsMultipartResolver commonsMultipartResolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setDefaultEncoding("UTF-8");
//        return commonsMultipartResolver;
//
//    }
}
