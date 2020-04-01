package go.com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class UseSemaphore {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(50);  //可以看到Semaphore的构造函数需要传递一个int类型数据，作用是限流，只能有5个线程同时访问
        ExecutorService pool = Executors.newCachedThreadPool();  //线程池
        for (int i = 0; i < 20; i++) { //模拟20个客户端访问
            int j = i + 1;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();
                        //模拟实际业务员逻辑
                        //Thread.sleep(1000 * new Random().nextInt(5));
                        Thread.sleep(2000);
                        System.out.println("任务" + j + "完成！");
                        //访问完后，释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            pool.execute(run);
        }
    }
}