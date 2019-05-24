package cn.learn.architect.interview.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class HelloGC {

    public static void main(String[] args) throws Exception {
        System.out.println("JVM参数....");
        //长时间运行，是为了查看进程信息
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

}
