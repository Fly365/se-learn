package cn.learn.architect.interview.base;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/18
 * DESC: SE基础练习
 */
public class BaseDemo01 {

    public static void main(String [] args){
        //校验字符串
        String str01 = "aaa";
        String str02 = new String("aaa");
        System.out.println("str01 == str02:" + (str01 == str02));
        System.out.println("str01.equals(str02):" + str01.equals(str02));
        System.out.println(2<<3);

    }

}
