package go.com.test;

import go.com.model.UserInfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SpringTest.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        UserInfoBean user = ctx.getBean("userInfo", UserInfoBean.class);
        UserInfoBean user2 = ctx.getBean("userInfo", UserInfoBean.class);
        System.out.println(user==user2);
    }
}
