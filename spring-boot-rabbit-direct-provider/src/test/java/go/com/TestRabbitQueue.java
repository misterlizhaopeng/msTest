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
    private Sender sender;


    @Test
    public void testSend() throws  Exception{

        while (true){
            Thread.sleep(1000);
            sender.send("hello rabbit!~");
        }


//        for (int i = 0; i < 100; i++) {
//            sender.send("hello rabbit!~");
//        }
    }
}
