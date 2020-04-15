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


    /*
    info:
      name: log.queue.info # 队列名称
      key: '*.log.info' # 路由键
    error:
      name: log.queue.error # 队列名称
      key: '*.log.error'  # 路由键
    log:
      name: log.queue.all # 队列名称
      key: '*.log.*'  # 路由键
*/

    public  void send(String msg){
        //参数1：队列名称；参数2：消息
        amqpTemplate.convertAndSend(exchangeName,"order.log.info", msg);//发送info日志，同时会匹配消费者端的路由键：*.log.*
        amqpTemplate.convertAndSend(exchangeName,"order.log.error", msg);//发送error日志，同时会匹配消费者端的路由键：*.log.*
    }
}
