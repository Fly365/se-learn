package cn.learn.architect.interview.jvm.oom;

import java.util.Random;

/**
 * ProjectName : interview-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class JavaHeapSpaceErrorDemo {

    // JVM -Xms5m -Xmx5m
    public static void main(String[] args) {
        String str = "JVM";
        //java.lang.OutOfMemoryError: Java heap space
        while(true){
            str += str + new Random().nextInt(7777) + new Random().nextInt(9999);
            str.intern();
        }
    }
}
