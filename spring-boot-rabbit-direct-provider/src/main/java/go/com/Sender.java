package go.com;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;

//消息发送者
@Component
public class Sender   {

    // 拿到rabbit的模板（spring 就喜欢模板；比如jdbcTemplate、restTemplate、redisTemplate等等）
    @Autowired
    private AmqpTemplate amqpTemplate;

    //交换器
    @Value("${rabbit.mqconfig.exchange}")
    private String exchangeName;
    //路由键
    @Value("${rabbit.mqconfig.error.key}")
    private String routeKey;



    public  void send(String msg){
        //参数1：队列名称；参数2：消息
        amqpTemplate.convertAndSend(exchangeName,routeKey, msg);
    }
}
