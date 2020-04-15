package go.com;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

//消息发送者
@Component
public class Sender {

    // 拿到rabbit的模板（spring 就喜欢模板；比如jdbcTemplate、restTemplate、redisTemplate等等）
    @Autowired
    private AmqpTemplate amqpTemplate;

    //交换器
    @Value("${rabbit.mqconfig.exchange}")
    private String exchangeName;
    //路由键
    @Value("${rabbit.mqconfig.error.key}")
    private String routeKey;


    //其实一个队列一种参数的消息即可!!!!
    public void sendStr(Map<String, Object> m) {
        amqpTemplate.convertAndSend(exchangeName, routeKey, m);
        amqpTemplate.convertAndSend(exchangeName, routeKey, 1);
        amqpTemplate.convertAndSend(exchangeName, routeKey, "2");

//        // 测试传递参数；
//        Integer i=1;
//        amqpTemplate.convertAndSend(exchangeName, routeKey, i);
//
//        //传递map类型的参数；
//        Map<String,Object> m=new HashMap<>();
//        m.put("1-m", "1-m-value");
//        m.put("2-m", "2-m-value");
//        m.put("3-m", "3-m-value");
//        m.put("4-m", "4-m-value");
//        amqpTemplate.convertAndSend(exchangeName, routeKey, m);


    }




   /* public void sendMap(Map<String,Object> m) {
        amqpTemplate.convertAndSend(exchangeName, routeKey, m,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                        return  message;
                    }
                });
    }*/
}
