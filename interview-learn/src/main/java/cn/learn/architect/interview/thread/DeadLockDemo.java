package cn.learn.architect.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * ProjectName : interview-learn
 * Description : []
 * 线程死锁的模拟实现
 * @author : Fly365
 * CreateDate : 2019年-05月-23日
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"Thread-A").start();
        new Thread(new HoldLockThread(lockB,lockA),"Thread-B").start();
    }

}

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "，持有lockA锁，尝试获取lockB锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + ",持有lockB锁，尝试获取lockA锁");
            }
        }
    }
}




