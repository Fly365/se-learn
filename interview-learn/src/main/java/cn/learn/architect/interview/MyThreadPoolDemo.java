package cn.learn.architect.interview;

import java.util.concurrent.*;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-22日
 */
public class MyThreadPoolDemo {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        //executorsDemo();
        ExecutorService threadPool = null;
        //任务到达 max + 阻塞队列数 = 5+3 = 8个，
        //超过8个就会报错，也就是允许接纳处理的总任务数
        threadPool = new ThreadPoolExecutor(2,5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),
                // 超过接纳任务数就抛出异常
                //new ThreadPoolExecutor.AbortPolicy());
                // 超出接纳任务数转交给 调用者(调用当前线程的线程)处理
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 处理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR:"+e.getLocalizedMessage());
        } finally {
            threadPool.shutdown();
        }

    }

    @SuppressWarnings("all")
    private static void executorsDemo() {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = null;
        threadPool = Executors.newFixedThreadPool(5);
        //threadPool = Executors.newSingleThreadExecutor();
        //threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 处理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
