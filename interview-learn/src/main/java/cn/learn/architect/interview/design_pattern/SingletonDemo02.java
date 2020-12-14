package cn.learn.architect.interview.design_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/14
 * DESC: 懒汉式+同步锁+double-check
 */
public class SingletonDemo02 {
    //不实例化
    private volatile static SingletonDemo02 instance = null;
    //list属性
    public List<String> list = null;
    //构造函数
    private SingletonDemo02(){
        list = new ArrayList<>();
    }
    //加同步锁，通过该函数向整个系统提供实例
    public static SingletonDemo02 getInstance(){
        //第一次判断，当instance为null时，则实例化，否则直接返回对象
        if(null == instance){
            //同步锁
            synchronized (SingletonDemo02.class){
                //第二次判断
                if(null == instance){
                    instance = new SingletonDemo02();
                }
            }
        }
        return instance;
    }
}
