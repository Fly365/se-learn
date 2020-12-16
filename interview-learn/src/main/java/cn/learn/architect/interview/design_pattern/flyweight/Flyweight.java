package cn.learn.architect.interview.design_pattern.flyweight;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: 抽象享元类
 */
public interface Flyweight {
    //对外状态对象
    void operation(String name);
    //对内对象
    String getType();
}
