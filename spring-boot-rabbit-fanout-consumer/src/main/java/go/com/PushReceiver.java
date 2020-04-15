package go.com;

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
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                exchange = @Exchange(value = "${rabbit.mqconfig.exchange}", type = ExchangeTypes.FANOUT),
                value = @Queue(value = "${rabbit.mqconfig.push.name}", autoDelete = "true")
        )
)
public class PushReceiver {
    @RabbitHandler
    public void recever(String msg) {

        System.out.println("receiver push is：" + msg);

    }
}
