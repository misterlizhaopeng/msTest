package go.com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01 {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test01 test = new Test01();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread() {
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }

            ;
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }


//    private static ThreadLocal<Connection> connectionHolder  = new ThreadLocal<Connection>() {
//        public Connection initialValue() {
//            return DriverManager.getConnection("");
//        }
//    };
//
//    public static Connection getConnection() {
//        return connectionHolder.get();
//    }
}