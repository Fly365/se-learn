package cn.learn.architect.interview.jvm.oom;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    // java.lang.StackOverflowError
    private static void stackOverflowError() {
        stackOverflowError();
    }

}
