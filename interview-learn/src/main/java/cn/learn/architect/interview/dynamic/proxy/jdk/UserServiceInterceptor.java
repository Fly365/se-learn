package cn.learn.architect.interview.dynamic.proxy.jdk;

import cn.learn.architect.interview.dynamic.proxy.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * architect-learn
 * User: Fly365
 * Date: 2021/1/2
 * DESC:
 */
public class UserServiceInterceptor implements InvocationHandler {
    private Object realObj;

    public Object getRealObj() {
        return realObj;
    }

    public void setRealObj(Object realObj) {
        this.realObj = realObj;
    }

    public UserServiceInterceptor(Object realObj){
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //该部分算是前置增强
        if(args != null && args.length > 0 && args[0] instanceof User){
            User user = (User)args[0];
            if(user.getName().trim().length() <= 1){
                throw new RuntimeException("用户名长度必须大于1！");
            }
        }
        Object ret = method.invoke(realObj,args);
        //这里算是后置增强
        System.out.println("数据操作成功！");
        return ret;
    }
}
