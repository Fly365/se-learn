package cn.learn.architect.interview.design_pattern;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/14
 * DESC: 原型模式
 */
class Student implements Cloneable {
    private String name;
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    //重写clone方法：浅拷贝
    /*@Override
    public Student clone() {
        Student student = null;
        try {
            student = (Student)super.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return student;
    }*/
    // 重写clone方法:深拷贝
    @Override
    public Student clone() {
        Student student = null;
        try {
            student = (Student)super.clone();
            Teacher teacher = this.teacher.clone();
            student.setTeacher(teacher);
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return student;
    }
}
class Teacher implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //重写clone方法
    @Override
    public Teacher clone(){
        Teacher teacher = null;
        try{
            teacher = (Teacher)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return teacher;
    }
}
public class PrototypeDemo01 {
    public static void main(String[] args){
        Teacher teacher = new Teacher();
        teacher.setName("刘老师");
        Student stu01 = new Student();
        stu01.setName("test01");
        stu01.setTeacher(teacher);

        Student stu02 = stu01.clone();
        stu02.setName("test02");
        stu02.getTeacher().setName("王老师");
        System.out.println("学生 " + stu01.getName()
                + " 的老师是:" + stu01.getTeacher().getName());
        System.out.println("学生 " + stu02.getName()
                + " 的老师是:" + stu02.getTeacher().getName());
    }
}
