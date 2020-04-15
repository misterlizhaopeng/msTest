package go.com.queue;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置文件
@Configuration
public class QueueConfig {

    //创建一个队列
    @Bean
    public Queue queue(){
        return new Queue("queue-name");// 队列名称
    }
}
