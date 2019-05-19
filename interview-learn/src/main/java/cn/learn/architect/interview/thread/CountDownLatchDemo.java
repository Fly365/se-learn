package cn.learn.architect.interview.thread;

import cn.learn.architect.interview.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-19日
 */
public class CountDownLatchDemo {

    private static final int TOTAL_NUM = 6;

    public static void main(String[] args) throws InterruptedException {
        //countDownLatchCase01();
        CountDownLatch countDownLatch = new CountDownLatch(TOTAL_NUM);

        //操作任务
        for (int i = 1; i <=6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国被灭");
                countDownLatch.countDown();
            }, CountryEnum.getCountryEnum(i).getRetMsg()).start();
        }

        //main等待计数为零
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "秦国统一天下");
    }

    private static void countDownLatchCase01() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(TOTAL_NUM);

        //操作任务
        for (int i = 1; i <=6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "离开办公室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        //main等待计数为零
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "关闭办公室门窗");
    }
}
