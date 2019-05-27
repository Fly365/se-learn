package cn.learn.architect.interview.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-25日
 */
public class MetaspaceOOMDemo {

    public static void main(String[] args) {
        int i = 0;
        //-XX:Metaspacesize=10m -XX:MaxMetaspaceSize=10m
        //发生异常时，操作计数为 401
        //java.lang.OutOfMemoryError: Metaspace
        try {
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invoke(o,args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("发生异常时，操作计数为 " + i);
            e.printStackTrace();
        }
    }

    static class OOMTest{

    }
}
