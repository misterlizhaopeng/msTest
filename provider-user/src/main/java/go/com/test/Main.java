package go.com.test;

import go.com.model.User;
import org.springframework.web.context.WebApplicationContext;
import sun.misc.GC;

import java.util.Random;

public class Main {
    Main instance;

    public static void main(String[] args) {
        User user = new User(1, "123");
        user=null;



        String str = "first String";

        while (true) {
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
        }


//        AbstractClsTest a = new AbstractB();
//        a.exeMethod();
//        System.out.println("----------------------------------------------------->");


//        ClassLoader classLoader = user.getClass().getClassLoader();
//        System.out.println("classLoader -->" + classLoader);
//        System.out.println("classLoader parent-->" + classLoader.getParent());
//        System.out.println("classLoader parent's parent-->" + classLoader.getParent().getParent());
//
//        System.out.println("string classLoader-->" + String.class.getClassLoader());
//        System.out.println("Integer classLoader-->" + Integer.class.getClassLoader());
//
//        System.out.println(String.class.getClassLoader() == String.class.getClassLoader());
//        System.out.println(String.class.getClassLoader() == classLoader.getParent().getParent());
//        System.out.println(Integer.class.getClassLoader() == classLoader.getParent().getParent());
//
//
//        System.out.println("WebApplicationContext's classLoader is -->" + WebApplicationContext.class.getClassLoader());

        //System.out.println(Arrays.asList(args));


    }
}
