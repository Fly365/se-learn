package cn.learn.architect.interview.dynamic.proxy.cglib;

import cn.learn.architect.interview.dynamic.proxy.User;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * architect-learn
 * User: Fly365
 * Date: 2021/1/2
 * DESC:
 */
public class UserServiceInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        if(objects != null && objects.length > 0 && objects[0] instanceof User){
            User user = (User)objects[0];
            if(user.getName().trim().length() <= 1){
                throw new RuntimeException("用户名长度必须大于1！");
            }
        }
        Object ret = methodProxy.invokeSuper(o,objects);
        System.out.println("数据操作成功!");
        return ret;
    }
}
