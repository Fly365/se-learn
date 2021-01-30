package cn.learn.architect.interview.dynamic.proxy.jdk;

import cn.learn.architect.interview.dynamic.proxy.User;

import java.lang.reflect.Proxy;

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
        UserService userService = new UserServiceImpl();
        UserServiceInterceptor userServiceInterceptor = new UserServiceInterceptor(userService);
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),userServiceInterceptor);
        proxy.addUser(user);
        System.out.println(proxy.hashCode());
    }
}
