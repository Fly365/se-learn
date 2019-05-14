package cn.learn.architect.interview.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS: 比较并交换 --> compareAndSet
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-14日
 */
public class CASDemo {

    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) +"\t currentVal=" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 2020) +"\t currentVal=" + atomicInteger.get());

        atomicInteger.getAndIncrement();
    }


}
