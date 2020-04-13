package go.com.queue;

import com.rabbitmq.http.client.domain.ExchangeType;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 消息接收者
 * @author Administrator
 * @RabbitListener bindings:绑定队列
 * @QueueBinding  value:绑定队列的名称
 *                exchange:配置交换器
 *
 * @Queue value:配置队列名称
 *        autoDelete:是否是一个可删除的临时队列,true表示可以删除，false表示停止监听之后，保留该队列
 *
 * @Exchange value:为交换器起个名称
 *           type:指定具体的交换器类型
 *
 *
 * 测试之后的结论：如果当前的direct类型的队列的消息积累了很多，停止生产者继续生产消息，然后打开消费者，可以一下接受所有的消息；
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                exchange = @Exchange(value = "${rabbit.mqconfig.exchange}", type = ExchangeTypes.DIRECT),
                value = @Queue(value = "${rabbit.mqconfig.info.name}", autoDelete = "true"),
                key = "${rabbit.mqconfig.info.key}"
        )
)
public class Receiver {
    //按照队列名称 监听队列
    @RabbitHandler
    public void recever(String msg) {

        System.out.println("receiver 接受到的消息为：" + msg);

    }
}
