package cn.learn.architect.interview.design_pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: 享元工厂类
 */
public class FlyweightFactory {
    //享元池，用来存储享元对象
   private static final Map<String,Flyweight> FLYWEIGHT_MAP = new HashMap<>();

   public static Flyweight getFlyweight(String type){
       if(FLYWEIGHT_MAP.containsKey(type)){
           //如果享元池中存在对象，则直接获取
           return FLYWEIGHT_MAP.get(type);
       } else {
           //如池中不存在，则新创建对象，并放入享元池
           ConcreteFlyweight flyweight = new ConcreteFlyweight(type);
           FLYWEIGHT_MAP.put(type, flyweight);
           return flyweight;
       }
   }

}
