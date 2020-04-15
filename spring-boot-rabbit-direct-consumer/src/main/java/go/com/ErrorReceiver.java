package go.com;

import com.rabbitmq.http.client.domain.ExchangeType;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * 消息接收者
 *
 * @author Administrator
 * @RabbitListener bindings:绑定队列
 * @QueueBinding value:绑定队列的名称
 * exchange:配置交换器
 * @Queue value:配置队列名称
 * autoDelete:是否是一个可删除的临时队列,true表示可以删除，false表示停止监听之后，保留该队列
 * @Exchange value:为交换器起个名称
 * type:指定具体的交换器类型
 * <p>
 * <p>
 * 测试之后的结论：如果当前的direct类型的队列的消息积累了很多，停止生产者继续生产消息，然后打开消费者，可以一下接受所有的消息；
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                exchange = @Exchange(value = "${rabbit.mqconfig.exchange}", type = ExchangeTypes.DIRECT),
                value = @Queue(value = "${rabbit.mqconfig.error.name}", autoDelete = "true"),
                key = "${rabbit.mqconfig.error.key}"
        )
)
public class ErrorReceiver {


    //其实一个队列一种参数的消息即可!!!!
    @RabbitHandler
    public void receiver(Map<String, Object> m) {
//        Map<String, Object> m = (HashMap<String, Object>) obj;
        System.out.println("receiver 接受到的消息为：" + m);
        //throw new RuntimeException();

        int i = 1;
        Map<String, Object> map = new HashMap<>();
        map.put("1", i);

      /*  try {

            System.out.println("receiver 接受到的消息为：" + msg);
            throw new RuntimeException();
        }
        catch (Exception ex){
            System.out.println("发生了异常，进行处理之");
        }*/
    }
    
    @RabbitHandler
    public void receiveInt(Integer a) {
        System.out.println("接收的整形：" + a);

        int i = 1;
        Map<String, Object> map = new HashMap<>();
        map.put("1", i);
    }

    //
//
    @RabbitHandler
    public void receiveString(String str) {
        System.out.println("接收的字符串：" + str);

        int i = 1;
        Map<String, Object> map = new HashMap<>();
        map.put("1", i);
    }
//
//    @RabbitHandler
//    public void receiveMap(Map<String, Object> m) {
//        System.out.println("接收的字符串：" + m);
//        int i = 1;
//        Map<String, Object> map = new HashMap<>();
//        map.put("1", i);
//    }
}
