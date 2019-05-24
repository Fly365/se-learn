package cn.learn.architect.interview.jvm.refer;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * ProjectName : interview-learn
 * Description : []
 * 测试使用WeakHashMap
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("-----------------------");
        myWeakHashMap();
    }

    private static void myHashMap() {
        Map<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}
