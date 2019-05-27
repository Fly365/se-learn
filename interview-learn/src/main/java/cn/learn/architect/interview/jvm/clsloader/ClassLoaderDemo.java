package cn.learn.architect.interview.jvm.clsloader;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-27日
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        ClassLoaderDemo loaderDemo = new ClassLoaderDemo();

        System.out.println(o1.getClass().getClassLoader());
        System.out.println(loaderDemo.getClass().getClassLoader().getParent().getParent());
        System.out.println(loaderDemo.getClass().getClassLoader().getParent());
        System.out.println(loaderDemo.getClass().getClassLoader());
    }

}
