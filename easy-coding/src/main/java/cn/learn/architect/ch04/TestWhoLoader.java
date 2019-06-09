package cn.learn.architect.ch04;

/**
 * ProjectName : architect-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-06月-06日
 */
public class TestWhoLoader {

    public static void main(String[] args) {
        ClassLoader c = TestWhoLoader.class.getClassLoader();
        ClassLoader c1 = c.getParent();
        ClassLoader c2 = c1.getParent();

        System.out.println("c class loader:" + c);
        System.out.println("c parent class loader:" + c1);
        System.out.println("c grandfather class loader:" + c2);
    }

}
