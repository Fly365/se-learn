package cn.learn.architect.interview.design_pattern;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.IntStream;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: 线程上下文，借助ThreadLocal实现
 */
public class ContextDemo02 {
    //上下文
    @Setter
    @Getter
    public static class Context{
        private String name;
        private long id;
    }
    //复制上下文到ThreadLocal中
    public final static class ActionContext{
        private static final ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<>(){
            @Override
            protected Context initialValue() {
                return new Context();
            }
        };
        public static ActionContext getActionContext(){
            return ContextHolder.ACTION_CONTEXT;
        }
        public Context getContext(){
            return THREAD_LOCAL.get();
        }
        //获取ActionContext单例
        public static class ContextHolder{
            private final static ActionContext ACTION_CONTEXT = new ActionContext();
        }
    }
    //设置上下文名字
    public class QueryNameAction{
        public void execute(){
            try{
                Thread.sleep(1000L);
                String name = Thread.currentThread().getName();
                ActionContext.getActionContext().getContext().setName(name);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //设置上下文id
    public class QueryIdAction {
        public void execute(){
            try{
                Thread.sleep(1000L);
                long id = Thread.currentThread().getId();
                ActionContext.getActionContext().getContext().setId(id);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //执行方法
    public class ExecutionTask implements Runnable {
        private QueryNameAction queryNameAction = new QueryNameAction();
        private QueryIdAction queryIdAction = new QueryIdAction();
        @Override
        public void run() {
            queryNameAction.execute();
            System.out.println("The name successful");
            queryIdAction.execute();
            System.out.println("The id successful");
            System.out.println("The name is " + ActionContext.getActionContext().getContext().getName()
                + " and id is " + ActionContext.getActionContext().getContext().getId());
        }
    }

    public static void main(String[] args){
        IntStream.range(1,5).forEach(i -> new Thread(new ContextDemo02().new ExecutionTask()).start());
    }
}
