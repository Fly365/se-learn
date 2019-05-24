package cn.learn.architect.interview.jvm.refer;

import java.lang.ref.WeakReference;

/**
 * ProjectName : interview-learn
 * Description : []
 * 弱引用
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        System.out.println("---------------");
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
    }

}
