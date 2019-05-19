package cn.learn.architect.interview.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ProjectName : interview-learn
 * Description : [原子引用解决ABA问题]
 * 解决ABA问题？ 原子引用 + 新增一种机制，修改版本号(类似时间戳)
 * @author : Fly365
 * CreateDate : 2019年-05月-18日
 */

public class AtomicReferenceDemo {

    public static void main(String[] args){
        User01 zhangSan = new User01("zhangshan",20);
        User01 liSi = new User01("lisi", 25);

        AtomicReference<User01> atomicReference = new AtomicReference<>();
        atomicReference.set(zhangSan);

        System.out.println(atomicReference.compareAndSet(zhangSan, liSi) + "\t" + atomicReference.get().toString());
    }
}
@Getter
@ToString
@AllArgsConstructor
class User01 {
    String username;
    int age;
}
