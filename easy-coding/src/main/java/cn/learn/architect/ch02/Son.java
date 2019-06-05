package cn.learn.architect.ch02;

/**
 * ProjectName : architect-learn
 * Description : []
 *  父类与子类 加载的顺序
 * @author : Fly365
 * CreateDate : 2019年-06月-03日
 */
public class Son extends Parent {

    static{
        System.out.println("son 静态代码块.....");
    }

    Son(){
        System.out.println("son 构造函数.....");
    }

    public static void main(String[] args) {
        new Son();
        new Son();
    }

}

class Parent {

    static{
        System.out.println("parent 静态代码块....");
    }

    Parent(){
        System.out.println("parent 构造函数.....");
    }

}
