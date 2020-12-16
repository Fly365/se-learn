package cn.learn.architect.interview.design_pattern;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.IntStream;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: 线程上下文设计模式
 */
public class ContextDemo {
    //上下文
    @Setter
    @Getter
    public class Context{
        private String name;
        private long id;
    }
    //设置上下文名字
    public class QueryNameAction{
        public void execute(Context context){
            try{
                Thread.sleep(1000L);
                String name = Thread.currentThread().getName();
                context.setName(name);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //设置上下文ID
    public class QueryIdAction{
        public void execute(Context context){
            try{
                Thread.sleep(1000L);
                long id = Thread.currentThread().getId();
                context.setId(id);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //执行方法
    public class ExecutionTask implements Runnable{
        private QueryNameAction queryNameAction = new QueryNameAction();
        private QueryIdAction queryIdAction = new QueryIdAction();
        @Override
        public void run() {
            final Context context = new Context();
            queryNameAction.execute(context);
            System.out.println("The name query successful");
            queryIdAction.execute(context);
            System.out.println("The id query successful");
            System.out.println("The name is " + context.getName() + " and id is " + context.getId());
        }
    }

    public static void main(String[] args){
        IntStream.range(1,5).forEach(i -> new Thread(new ContextDemo().new ExecutionTask()).start());
    }

}
