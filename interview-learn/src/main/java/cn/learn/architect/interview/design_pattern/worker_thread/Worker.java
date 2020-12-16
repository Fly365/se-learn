package cn.learn.architect.interview.design_pattern.worker_thread;

import java.util.Random;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: 机器人
 */
public class Worker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());
    private final PackageChannel channel;
    public Worker(String name,PackageChannel channel){
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true){

        }
    }
}
