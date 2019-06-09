package cn.learn.architect.ch04;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * ProjectName : architect-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-06月-06日
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if(result == null){
                throw new FileNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException();
    }

    /**从自定义路径中加载类*/
    private byte[] getClassFromCustomPath(String name){
        return null;
    }

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("TestWhoLoader", true, customClassLoader);
            Object obj = clazz.getDeclaredConstructor().newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
