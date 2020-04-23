package cn.learn.architect.interview.jvm.gc;

import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.Cleaner;

/**
 * ProjectName : architect-learn
 * Description : []
 * 测试Cleaner替换finalize的方案demo
 * @author : Fly365
 * CreateDate : 2019年-08月-03日
 */
public class CleaningExample implements Closeable {

    private static final Cleaner CLEANER = Cleaner.create();

    static class State implements Runnable {
        State(){

        }

        @Override
        public void run() {

        }
    }

    private final State state;
    private final Cleaner.Cleanable cleanable;

    public CleaningExample(){
        this.state = new State();
        this.cleanable = CLEANER.register(this,state);
    }

    @Override
    public void close() throws IOException {
        cleanable.clean();
    }
}
