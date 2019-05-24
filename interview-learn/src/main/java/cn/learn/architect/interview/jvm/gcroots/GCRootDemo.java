package cn.learn.architect.interview.jvm.gcroots;

/**
 * ProjectName : interview-learn
 * Description : []
 * 在Java中，可作为GC Roots对象有：
 * 1.虚拟机栈(栈帧中的本地变量表)中引用的对象
 * 2.方法区中的类静态属性引用的对象
 * 3.方法区中常量引用的对象
 * 4.本地方法栈中JNI(即一般说Native方法)中引用的对象
 * @author : Fly365
 * CreateDate : 2019年-05月-24日
 */
public class GCRootDemo {

    private byte[] byteArr = new byte[100 * 1024 * 1024];

    //private static GCRootDemo2 t2;
    //private static final GCRootDemo3 t3 = new GCRootDemo3(8);

    public static void main(String[] args) {
        m1();
    }

    //方法m1要在栈中，方法中有局部变量t1，
    //t1就是虚拟机栈中的对象
    private static void m1() {
        GCRootDemo t1 = new GCRootDemo();
        System.gc();
        System.out.println("第一层GC完成");
    }
}
