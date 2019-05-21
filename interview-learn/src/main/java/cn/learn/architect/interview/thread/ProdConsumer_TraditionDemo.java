package cn.learn.architect.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProjectName : interview-learn
 * Description : []
 * 一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，执行五次
 * 1. 线程    操作(方法)  资源类
 * 2. 判断    干活  通知
 * 3. 防止虚假唤醒机制 -- 注意多线程判断用while不要用if
 *      synchronized (obj) {
 *          while (<condition does not hold>)
 *              obj.wait();
 *          ... // Perform action appropriate to condition
 *      }
 * @author : Fly365
 * CreateDate : 2019年-05月-20日
 */
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        //-------------增加线程校验while逻辑，以及多于2个线程使用if错误逻辑---------

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t3").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t4").start();
    }

}

class ShareData {

    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //1.判断
            while(num != 0){
                //等待，不能生产
                condition.await();
            }
            //2.干活
            num++;
            System.out.println(Thread.currentThread().getName() + " increment num");
            // 3.通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //1.判断
            while(num == 0){
                //等待，不能生产
                condition.await();
            }
            //2.干活
            num--;
            System.out.println(Thread.currentThread().getName() + " decrement num");
            // 3.通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}









