package go.com.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


//消息接受者，利用消息的监听机制
@Component
public class Receiver {


    //按照队列名称 监听队列
    @RabbitListener(queues = {"queue-name"})
    public void recever(String msg) {

        System.out.println("receiver 接受到的消息为：" + msg);

    }
}
