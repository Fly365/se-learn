package cn.learn.architect.interview.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName : interview-learn
 * Description : []
 * 98%时间用来做GC回收了不到2%堆内存
 * JVM参数配置测试
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            //java.lang.OutOfMemoryError: GC overhead limit exceeded
            while(true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("current number="+i);
            e.printStackTrace();
            throw e;
        }
    }

}
