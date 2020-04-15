package go.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 测试
@RunWith(SpringRunner.class)
@SpringBootTest(classes = go.com.SpringStarter.class)
public class TestRabbitQueue {

    @Autowired
    private OrderSender orderSender;


    @Test
    public void testSend()  {

        orderSender.send("order send--");

//        for (int i = 0; i < 100; i++) {
//            sender.send("hello rabbit!~");
//        }
    }
}
