package cn.learn.architect.interview.jvm.oom;

/**
 * ProjectName : interview-learn
 * Description : []
 * 1.
 * -Xmx10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC  (DefNew+Tenured)
 * 2.
 * -Xmx10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC  (ParNew+Tenured)
 * 3.
 * -Xmx10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC  (PSYongGen+ParOldGen)
 * 4.
 * 4.1
 * -Xmx10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC  (PSYongGen+ParOldGen)
 * 4.2 不加默认就是UseParallelGC
 * -Xmx10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags  (PSYongGen+ParOldGen)
 * @author : Fly365
 * CreateDate : 2019年-05月-25日
 */
public class GCDemo {



}
