package cn.learn.architect.interview.design_pattern.flyweight;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: 享元模式测试
 */
public class FlyweightClient {

    public static void main(String[] args){
        Flyweight fw0 = FlyweightFactory.getFlyweight("a");
        Flyweight fw1 = FlyweightFactory.getFlyweight("b");
        Flyweight fw2 = FlyweightFactory.getFlyweight("a");
        Flyweight fw3 = FlyweightFactory.getFlyweight("b");
        fw1.operation("abc");
        System.out.printf("[结果(对象对比)] - [%s]\n", fw0 == fw2);
        System.out.printf("[结果(内在状态)] - [%s]\n", fw1.getType());
    }

}
