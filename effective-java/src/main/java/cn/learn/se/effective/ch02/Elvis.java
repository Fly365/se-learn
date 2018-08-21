package cn.learn.se.effective.ch02;

/**
 * effective-java-cn.learn.se.effective.ch02
 * 枚举方式的单例
 * @author : WXF
 * @date : 2018年-08月-21日
 */
public enum Elvis {
    /**单例*/
    INSTANCE;

    public void sayHello(String name){
        System.out.printf("hello,%s",name);
    }

    public static void main(String[] args){
        Elvis elvis = Elvis.INSTANCE;
        elvis.sayHello("effective java!");
    }

}
