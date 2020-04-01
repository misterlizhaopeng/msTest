package go.com.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import go.com.model.User;
import go.com.model.UserInfoBean;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;





    @Value("${server.port}")
    private String port;

    @GetMapping("/hello/{id}")
    public User hello(@PathVariable("id") String id, HttpServletRequest request, HttpSession session) {
//        System.out.println("equals----->" + (request.getServletContext() == session.getServletContext()));


        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
//        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
//        Map<String, UserInfoBean> maps = ctx.getBeansOfType(UserInfoBean.class);

//        UserInfoBean userInfoBean = ctx.getBean("userInfoBean", UserInfoBean.class);
//        System.out.println(userInfoBean);

        InstanceInfo eureka = eurekaClient.getNextServerFromEureka("provider-user", false);
        System.out.println(eureka.getHomePageUrl());

//        System.out.println(port);

//        int i=0;
//        i=100/i;

        return new User(Integer.parseInt(id), port);
//        return new User(Integer.parseInt(id));
    }

    @GetMapping("testMethod")
    public String getTestMethod (){
        return "测试接口"+port;
    }
    //    @RequestMapping(value = "/hello-user",method = RequestMethod.POST)  //√
    @PostMapping("/hello-user")
    public User a(@RequestBody User user) {


        System.out.println("---------->ok,port:" + port);
        return new User(user.getId(), port);
    }





    //
    public static Boolean isCanLinkDb = true;

    @RequestMapping(value = "/linkDb/{can}", method = RequestMethod.GET)
    public void LinkDb(@PathVariable Boolean can) {
        isCanLinkDb = can;
    }

}
