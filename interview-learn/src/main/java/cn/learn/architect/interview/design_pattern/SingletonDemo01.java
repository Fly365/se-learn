package cn.learn.architect.interview.design_pattern;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/14
 * DESC: 饿汉模式
 */
public class SingletonDemo01 {
    //自行创建实例
    private static SingletonDemo01 instance = new SingletonDemo01();
    //构造函数
    private SingletonDemo01(){}
    //通过该函数向整个系统提供实例
    public static SingletonDemo01 getInstance(){
        return instance;
    }
}
