package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
@EnableZuulProxy  //作用：启用zuul自带的熔断和自动注册到eureka中，注意：需要导入eureka客户端依赖
public class ZuulStarter {
    public static void main(String[] args) {


//        HashSet<String> hs=new HashSet<>();
//        hs.add("abc");
//        hs.add("bbb");
        SpringApplication.run(ZuulStarter.class,args);



    }

//    @Bean
//    public PatternServiceRouteMapper patternServiceRouteMapper(){
//        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)",
//                "${version}/${name}");
//    }




}