package cn.learn.architect.interview.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile不保证原子性
 * 1.原子性？
 *      不可分割，完整性，即某个线程正在做某个具体业务时，
 *      中间不可以被加塞或者被分割，需要整体完整，要么同
 *      时成功，要么同时失败。
 * 2，案例测试
 * 3.解决方案
 *  - 使用synchronized
 *  - 使用原子类进行操作
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-12日
 */
public class VolatileDemo02 {

    public static void main(String[] args) {
        MyData02 myData02 = new MyData02();
        //创建20个线程
        for(int i=1; i<=20; i++){
            new Thread(() -> {
                for(int j=1; j<= 1000; j++){
                    myData02.addPlus();
                    myData02.addAtomicInteger();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程全部计算完成，再用main线程
        //获取最终的结果值, 1个main 线程，其他就是创建的线程
        while(Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println("type int,最后计算结果,number=" + myData02.number);
        System.out.println("type AtomicInteger,最后计算结果,atomicInteger=" + myData02.atomicInteger);
    }

}

class MyData02 { //MyData2.java ==> MyData2.class ==> JVM字节码

    volatile int number = 0;

    public void changTo99(){
        number = 99;
    }

    public void addPlus(){
        number++;
    }

    //解决处理保证原子性
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomicInteger(){
        atomicInteger.getAndIncrement();
    }
}
