package cn.learn.architect.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ProjectName : interview-learn
 * Description : []
 * 实现一个自旋锁
 * 自旋锁好处： 循环比较获取直到成功为止，没有类似wait的阻塞
 * 通过CAS操作完成自旋锁，A线程先来调用myLock方法自己持有锁5秒钟，
 * B线程随后进来后发现当前有线程持有锁，不是null，所以只能通过自旋
 * 等待，直到A释放锁后B随后抢到
 * A method myLock
 * B method myLock
 * A invoke myUnlock
 * B invoke myUnlock
 * @author : Fly365
 * CreateDate : 2019年-05月-19日
 */
public class SpinLockDemo {

    // 原子引用线程

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " method myLock");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName() + " invoke myUnlock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"B").start();
    }
}
