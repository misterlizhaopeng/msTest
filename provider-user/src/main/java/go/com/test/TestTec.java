package go.com.test;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TestTec  {


    @Test
    public void testConcurrentHashMap() {
        ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();
        hashMap.put("a", "avale");
        hashMap.put("b", 222);
        hashMap.put("ac", 444);
        for (String s : hashMap.keySet()) {
            System.out.println(s);
            System.out.println("-->" + hashMap.get(s));
        }
    }


    ZkClient zkClient = new ZkClient("192.168.25.128:2181", 1000,
            1000, new SerializableSerializer());

    @Test
    public void testCreateZookeeperNodes() {
        System.out.println("add go--->");

        for (int i = 0; i < 10; i++) {
            zkClient.createPersistent("/spring-cloud-" + i, "spring-cloud-data_" + i);
        }
        System.out.println("add ok---->");

    }

    @Test
    public void testDeleteZookeeperNodes() {
        System.out.println("delete go--->");
        for (int i = 0; i < 10; i++) {
            boolean delete = zkClient.delete("/spring-cloud-" + i);

            if (delete) {
                System.out.println("delete success");
            }
        }
        System.out.println("delete ok---->");

    }

    @Test
    public void searchZookeeper() {
        List<String> g = zkClient.getChildren("/");
        for (String s : g) {
            System.out.println(s);
            if (s.startsWith("bg")) {

                Object o = zkClient.readData("/" + s);
                System.out.println("data-->" + o);
            }
        }
    }

    @Test
    public void searchZookeeper01() {
        List<String> children = zkClient.getChildren("/bg0000000063");
        for (String s : children) {
            System.out.println("data-->" + s);
        }
    }


    /**
     * 测试方法
     */
    @Test
    public void test01() {
//        String str2 = "SEUCalvin".toLowerCase();
//        String s1 = "abc";
//        String s2 = new String("abc");
//        s2=s2.intern();
//        System.out.println(s1 == s2);


    }
}
