package cn.learn.architect.interview.jvm.oom;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * ProjectName : interview-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-05月-25日
 */
public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
       //配置maxDirectMemory大小
        System.out.println("DirectMemory:" +
                (sun.misc.VM.maxDirectMemory()/(double)1024/1024 + "MB"));

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //-Xms10m -Xmx10m -XX:+PrintGCTetails -XX:MaxDirectMemorySize=5m
        //java.lang.OutOfMemoryError: Direct buffer memory
        ByteBuffer buf = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
