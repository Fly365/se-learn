package cn.learn.architect.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * 1.验证volatile可见性 - 增加volatile关键字和不带该关键字的区别
 * volatile可以保证可见性，及时通知其他线程，主内存的值已经被修改
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-12日
 */
public class VolatileDemo01 {

    public static void main(String[] args){
        MyData myData = new MyData();
        //开启一个线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程运行...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //休眠5秒钟后，修改number的值
            myData.changeTo99();
            System.out.println(Thread.currentThread().getName() + " 线程结束...,number=" + myData.number);
        },"AA").start();

        //main主线程
        while(myData.number == 0){
            // 当number值不为0时，停止循环
        }
        System.out.println(Thread.currentThread().getName() + " 线程结束,number="+myData.number);

    }
}

class MyData {
    /**volatile关键字区别*/
    volatile int number = 0;

    public void changeTo99(){
        number = 99;
    }
}
