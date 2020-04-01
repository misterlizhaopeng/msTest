package go.com;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationLoad {

    @Bean
    public IRule myRule() {
        /*
         * 默认是轮询算法，如果被轮训的微服务down机，
         * 前几次当轮询到down机的服务会响应失败，过一段时间，就会从正常的服务中再次进行轮询；
         * */
        //return new RetryRule();//我的测试，是不行的（我的测试方法是：把所有Eureka服务都启动，把所有微服务都启动，最后启动消费者，list不断查询，down掉其中的一个微服务，再list查询，一直会有对down的微服务的请求，不知道哪里配错了，先把这个问题留下！！！）

        //return new RandomRule();//随机访问指定的服务；
         return new RoundRobinRule();//轮询算法
    }

//    @Bean
//    public DiscoveryClient getDiscoveryClient(){
//        return new EurekaDiscoveryClient
//    }

}
