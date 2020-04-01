package go.com.test;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
    public static void main(String[] args) {
//        System.out.println("main ---> " + Thread.currentThread().getName());
//        T1   t1= new T1();
//        System.out.println("t1---------------->"+t1.getName());
//        t1.start();
//
//        T1 t2=new T1();
//        System.out.println("t2---------------->"+t2.getName());
//        t2.start();
//
//        T1 t3=new T1();
//        System.out.println("t3---------------->"+t3.getName());
//        t3.start();
//
//
//        ReentrantLock lock = new ReentrantLock();
//
//        Condition c1 = lock.newCondition();
//        Condition c2 = lock.newCondition();
//
//
        T2 t21 = new T2();
        String call;
        try {
            call = t21.call();
            System.out.println("out:------->" + call);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


//        c1.await();
//        c1.signal();
//        c2.signalAll();


    }
}


class T2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "saaaa--------->";
    }
}


class T1 extends Thread {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread() == this);
    }


    String goStr() {
        return "abc";
    }
}