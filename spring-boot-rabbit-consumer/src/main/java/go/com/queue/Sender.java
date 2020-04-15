package go.com.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//消息发送者
@Component
public class Sender implements ApplicationContextAware {

    public ApplicationContext ctx;

    // 拿到rabbit的模板（spring 就喜欢模板；比如jdbcTemplate、restTemplate、redisTemplate等等）
    @Autowired
    private AmqpTemplate amqpTemplate;

    public  void send(String msg){
        //参数1：队列名称；参数2：消息
        amqpTemplate.convertAndSend("queue-name", msg);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx=applicationContext;
    }
}
