package go.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

// 测试
@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = go.com.SpringStarter.class)
public class TestRabbitQueue {
    @Autowired
    private Sender sender;


    @Test
    public void testSend() throws Exception {
        Map<String, Object> m = new HashMap<>();
        m.put("1-m", "1-m-value");
        m.put("2-m", "2-m-value");
        m.put("3-m", "3-m-value");
        m.put("4-m", "4-m-value");

        sender.sendStr(m);


//        long count=0;
//
//        while (true) {
//            Thread.sleep(1000);
//            count++;
//            sender.send("hello rabbit!~,count="+count);
//        }

//        while (true){
//            Thread.sleep(1000);
//            sender.send("hello rabbit!~");
//        }


//        for (int i = 0; i < 100; i++) {
//            sender.send("hello rabbit!~");
//        }
    }
}
