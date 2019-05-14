package cn.learn.architect.interview.thread;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-14日
 */
public class SingletonDemo {

    //private static SingletonDemo instance = null;

    //加上volatile关键字禁止指令重排
    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println("Singleton 构造器.....");
    }

    // DCL(double check lock双端检锁机制)
    public static SingletonDemo getInstance(){
        if(instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

}
