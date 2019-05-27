package cn.learn.architect.interview.jvm.refer;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * ProjectName : interview-learn
 * Description : []
 * 虚引用
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("-------------------");
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }

}
