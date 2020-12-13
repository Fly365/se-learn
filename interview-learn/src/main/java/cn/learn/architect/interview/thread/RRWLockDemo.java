package cn.learn.architect.interview.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/11
 * DESC: 读写锁
 */
public class RRWLockDemo {
    private double x,y;
    private ReentrantReadWriteLock rrwLock = new ReentrantReadWriteLock();
    private Lock rLock = rrwLock.readLock();
    private Lock wLock = rrwLock.writeLock();

    public double read(){
        rLock.lock();
        try{
            return Math.sqrt(x*x + y * y);
        }finally {
            rLock.unlock();
        }
    }

    public void move(double deltaX, double deltaY){
        wLock.lock();
        try{
            x += deltaX;
            y += deltaY;
        }finally {
            wLock.unlock();
        }
    }
}
