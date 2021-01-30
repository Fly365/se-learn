package cn.learn.architect.interview.dynamic.proxy.cglib;

import cn.learn.architect.interview.dynamic.proxy.User;

/**
 * architect-learn
 * User: Fly365
 * Date: 2021/1/2
 * DESC:
 */
public class UserServiceImpl {
    public void addUser(User user) {
        System.out.println("用户数据保存成功，数据为:"+user.toString());
    }
}
