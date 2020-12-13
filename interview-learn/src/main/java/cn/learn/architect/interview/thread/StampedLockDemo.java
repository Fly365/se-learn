package cn.learn.architect.interview.thread;

import java.util.concurrent.locks.StampedLock;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/13
 * DESC: 读写锁的再优化，相对ReentrantReadWriteLock而言
 */
public class StampedLockDemo {

    private double x,y;
    private final StampedLock sl = new StampedLock();

    void move(double deltaX,double deltaY){
        //获取写锁
        long stamp = sl.writeLock();
        try{
            x += deltaX;
            y += deltaY;
        }finally {
            sl.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin(){
        //乐观读
        long stamp = sl.tryOptimisticRead();
        //拷贝变量
        double currX = x, currY = y;
        //判断读期间是否有写操作
        if(!sl.validate(stamp)){
            //升级为悲观读
            stamp = sl.readLock();
            try{
                currX = x;
                currY = y;
            }finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currX * currX + currY * currY);
    }
}
