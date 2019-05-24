package cn.learn.architect.interview.jvm.refer;

import java.lang.ref.SoftReference;

/**
 * ProjectName : interview-learn
 * Description : []
 * 软引用
 * 内存够用，就不回收，内存不够用，回收空间
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class SoftReferenceDemo {

    public static void softRefMemoryEnough(){
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());

        obj1 = null;
        System.gc();
        System.out.println(obj1);
        System.out.println(softReference.get());
    }

    /**
     * JVM配置，故意产生大对象并配置小的内存，让内存不够用导致OOM，
     * 看软引用的回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRefMemoryNotEnough(){
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());
        obj1 = null;

        try {
            byte[] byteArr = new byte[10 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(obj1);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args) {
        //softRefMemoryEnough();
        softRefMemoryNotEnough();
    }
}
