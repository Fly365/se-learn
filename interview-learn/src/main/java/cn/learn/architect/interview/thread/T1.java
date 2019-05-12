package cn.learn.architect.interview.thread;

/**
 * 检查查看该类的字节码
 * ProjectName: interview-learn
 * Description: []
 * Author: Fly365
 * CreateDate: 2019年-05月-13日
 */
public class T1 {

    volatile int number = 0;

    public void addPlus(){
        number++;
    }
}
