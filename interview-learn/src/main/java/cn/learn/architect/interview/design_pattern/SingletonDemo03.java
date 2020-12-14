package cn.learn.architect.interview.design_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/14
 * DESC: 通过内部类方式实现
 */
public class SingletonDemo03 {
    public List<String> list = null;
    private SingletonDemo03(){
        list = new ArrayList<>();
    }
    //内部类
    public static class InnerSingleton {
        //自行创建实例
        private static SingletonDemo03 instance = new SingletonDemo03();
    }

    //返回内部类中静态实例
    public static SingletonDemo03 getInstance(){
        return InnerSingleton.instance;
    }
}
