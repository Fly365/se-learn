package cn.learn.architect.interview.design_pattern.worker_thread;

import lombok.Getter;
import lombok.Setter;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: 包裹类
 */
@Setter
@Getter
public class Package {
    private String name;
    private String address;
    public void execute(){
        System.out.println(Thread.currentThread().getName() + " executed " + this);
    }
}
