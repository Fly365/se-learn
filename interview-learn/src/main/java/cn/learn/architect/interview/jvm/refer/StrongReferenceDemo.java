package cn.learn.architect.interview.jvm.refer;

/**
 * ProjectName : interview-learn
 * Description : []
 * 强引用
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        // 如此定义默认为强引用
        Object obj1 = new Object();
        // 引用赋值
        Object obj2 = obj1;
        //置空
        obj1 = null;
        System.gc();
        System.out.println(obj2);
    }


}
