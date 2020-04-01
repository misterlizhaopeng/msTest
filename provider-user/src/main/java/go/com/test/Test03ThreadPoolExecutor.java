package go.com.test;


import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.concurrent.*;

public class Test03ThreadPoolExecutor {
    public static void main(String[] args) {


//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
//                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
//        for (int i = 0; i < 16; i++) {
//            MyTask myTask = new MyTask(i);
//            executor.execute(myTask);
//            System.out.println("线程池中线程数:" + executor.getPoolSize() + ",队列中等待执行的任务的数量：" + executor.getQueue().size()
//                    + ",已经执行完的任务数量：" + executor.getCompletedTaskCount());
//        }
//        executor.shutdown();

//
//        Semaphore s = new Semaphore(5);
//        //8个工人，只有五个许可（也就是五个机器可以被5个人使用）
//        for (int i = 0; i < 8; i++) {
//            new Worker(i, s).start();
//        }


        Task task = new Task();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(task);
//        boolean cancel = future.cancel(true);
//        System.out.println(future.isCancelled());
//        System.out.println(cancel);
        try {
            System.out.println("执行结果为：" + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    }
}


class Worker extends Thread {
    private int num;
    private Semaphore semaphore;

    public Worker(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("工人：" + this.num + " 开始干活");
            semaphore.acquire();//获取一个许可
            Thread.currentThread().sleep(2000);
            System.out.println("工人：" + this.num + " 干活ok--->>>>");
            semaphore.release();//释放一个许可
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyTask implements Runnable {

    private Integer num;

    public MyTask(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行的task：" + num);
        try {
            Thread.currentThread().sleep(4000);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("task:" + num + " 执行完毕");
    }
}
