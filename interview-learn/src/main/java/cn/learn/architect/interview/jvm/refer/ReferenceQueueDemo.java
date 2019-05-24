package cn.learn.architect.interview.jvm.refer;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws Exception {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("--------------------");
        o1 = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }

}
