package cn.learn.architect.interview.jvm.oom;

import java.util.concurrent.TimeUnit;

/**
 * ProjectName : interview-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-05月-25日
 */
public class UnableCreateNewThreadDemo {

    public static void main(String[] args) {
        //java.lang.OutOfMemoryError: unable to create new native thread
        //at java.lang.Thread.start0(Native Method)
        for (int i = 0; ; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }

}
