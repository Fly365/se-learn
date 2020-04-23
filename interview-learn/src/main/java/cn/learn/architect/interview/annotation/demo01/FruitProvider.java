package cn.learn.architect.interview.annotation.demo01;

import java.lang.annotation.*;

/**
 * ProjectName : architect-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-06月-12日
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    public int id() default 1;

    public String name() default "";

    public String address() default "";

}
