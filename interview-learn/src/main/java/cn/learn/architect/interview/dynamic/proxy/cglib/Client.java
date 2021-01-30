package cn.learn.architect.interview.dynamic.proxy.cglib;

import cn.learn.architect.interview.dynamic.proxy.User;
import net.sf.cglib.proxy.Enhancer;

/**
 * architect-learn
 * User: Fly365
 * Date: 2021/1/2
 * DESC:
 */
public class Client {
    public static void main(String[] args){
        User user = new User();
        user.setId(1);
        user.setName("1");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new UserServiceInterceptor());
        UserServiceImpl userService01 = (UserServiceImpl)enhancer.create();
        userService01.addUser(user);
    }
}
