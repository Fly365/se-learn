package cn.learn.architect.interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ProjectName : interview-learn
 * Description : []
 * volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 * @author : Fly365
 * CreateDate : 2019年-05月-20日
 */
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 启动生产者成功");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"product").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动消费者成功");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒钟时间，main线程退出");
        try {
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyResource {
    /**默认开启，生产+消费*/
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    /**注意抽象传递的是接口，不能是固定的实现类*/
    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retFlag;
        while(flag){
            data = atomicInteger.incrementAndGet() + "";
            retFlag = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retFlag){
                System.out.println(Thread.currentThread().getName() + " 加入数据" + data + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + " 加入数据" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + " 生产停止，flag=false。");
    }

    public void myConsumer() throws Exception {
        String result = null;
        while(flag){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(result == null || "".equalsIgnoreCase(result)){
                flag = false;
                System.out.println(Thread.currentThread().getName() + " 超过2秒钟没有数据，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + " 消费 " + result + "成功");
        }
    }

    public void stop() throws Exception{
        this.flag = false;
    }
}












