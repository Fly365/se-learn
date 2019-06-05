package cn.learn.architect.ch02;

/**
 * ProjectName : architect-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-06月-04日
 */
public class RefObjectDemo {
    // 对象头最小占用空间12个字节


    //下面4个byte类型分配后，对象占用空间是 16个字节
    byte b1;
    byte b2;
    byte b3;
    byte b4;


    //下面每个引用变量占用 4个字节，共 20个字节
    Object obj1;
    Object obj2;
    Object obj3;
    Object obj4;


    //RefObjOther实例占用空间并不计算在本对象内，
    //依然只计算引用变量refvar大小 4个字节
    RefObjOther o1 = new RefObjOther();
    RefObjOther o2 = new RefObjOther();

    //综上，RefObjectDemo对象占用:
    // 12B + (1B * 4) + (4B * 5) + (4B * 2) = 44个字节
    // 取 8的倍数为 48个字节


}

class RefObjOther {
    // double类型占用8个字节，但此处是 数组引用变量
    //所以对象头 12B + 4B = 16B,并非8012个字节
    //这个数组引用的是double [] 类型，指向实际分配的数组空间首地址
    // 在new对象时，已经实际分配空间
    double [] d = new double[1000];
}
