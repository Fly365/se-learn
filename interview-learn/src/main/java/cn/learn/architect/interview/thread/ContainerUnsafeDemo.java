package cn.learn.architect.interview.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ProjectName : interview-learn
 * Description : [集合不安全demo]
 * @author : Fly365
 * CreateDate : 2019年-05月-18日
 */
public class ContainerUnsafeDemo {

    public static void main(String[] args) {
        List<String> strList;
        //List<String> strList = Arrays.asList("a","b","c");
        //strList.forEach(System.out::println);
        // strList = new ArrayList<>();
        strList = new CopyOnWriteArrayList<>();

        // java.util.ConcurrentModificationException
        for(int i=0; i<30; i++){
            new Thread(() -> {
                strList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(strList);
            },String.valueOf(i)).start();
        }

        /*
         * 1.故障现象
         *  java.util.ConcurrentModificationException
         * 2.导致原因: 并发修改导致
         * 3.解决方案
         *  3.1 new Vector<>()
         *  3.2 Collections.synchronizedList(new ArrayList<>());
         *  3.3 new CopyOnWriteArrayList<>()
         * 4.优化建议
         */
    }

}
