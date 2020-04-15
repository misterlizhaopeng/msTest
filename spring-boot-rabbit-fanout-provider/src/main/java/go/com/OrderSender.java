package go.com;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//消息发送者
@Component
public class OrderSender {

    // 拿到rabbit的模板（spring 就喜欢模板；比如jdbcTemplate、restTemplate、redisTemplate等等）
    @Autowired
    private AmqpTemplate amqpTemplate;

    //交换器
    @Value("${rabbit.mqconfig.exchange}")
    private String exchangeName;


    public  void send(String msg){
        amqpTemplate.convertAndSend(exchangeName,"", msg);//交换器为fanout类型，第二个的路由键为空即可
    }
}
