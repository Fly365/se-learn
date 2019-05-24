package cn.learn.architect.interview.jvm.gc;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class JVMParamsDemo {

    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("totalMemory(-Xms)" + totalMemory +"字节,"
                + (totalMemory/(double)1024/1024) + "MB");
        System.out.println("totalMemory(-Xmx)" + maxMemory +"字节,"
                + (maxMemory/(double)1024/1024) + "MB");

        byte[] byteArr = new byte[30 * 1024 * 1024];
    }

}
