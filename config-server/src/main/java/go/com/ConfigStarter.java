package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 * 1.创建git
 * 2.yml配置文件
 * 3.注解
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigStarter
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigStarter.class, args);
    }
}
