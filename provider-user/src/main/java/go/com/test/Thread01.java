package go.com.test;

public class Thread01 extends Thread {
    private static Integer C_M = 10;


    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            C_M--;
        }
        System.out.println("Thread01  extends  Thread.run()--------> was invoked!" + C_M);
    }
}
