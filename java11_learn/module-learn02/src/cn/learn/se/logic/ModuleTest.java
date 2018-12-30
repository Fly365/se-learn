package cn.learn.se.logic;

import cn.learn.se.entity.Person;
import org.junit.Test;

/**
 * java11_learn - cn.learn.se.logic
 * 2018年-12月-30日
 * @author Fly365
 */
public class ModuleTest {

    public static void main(String[] args){

        Person person = new Person(1L,"tom",20);
        System.out.println(person);

    }

    @Test
    public void test01(){
        Person person = new Person(3L,"Jerry",33);
    }


}
