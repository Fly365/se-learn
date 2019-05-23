package cn.learn.architect.interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ProjectName : interview-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-05月-21日
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread t1 = new Thread(futureTask,"A");
        t1.start();
        // 要求获得callable计算结果，如果没有计算完，就要去强求，
        // 会导致阻塞，直到计算完成
        System.out.println(futureTask.get());
    }

}


class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 2019;
    }

}
