package go.com;

import go.com.queue.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

// 测试
@RunWith(SpringRunner.class)
@SpringBootTest(classes = go.com.RabbitTestStarter.class)
public class TestRabbitQueue {
    @Autowired
    private Sender sender;


    @Test
    public void testSend(){
        System.out.println("------------------------------------------------------>");

//        String[] s = sender.ctx.getBeanDefinitionNames();
//        List<String> list =
//                Arrays.asList(s);
//        list.forEach(a->{
//            System.out.println(a);
//        });

        sender.send("hello rabbit!~");
    }
}
