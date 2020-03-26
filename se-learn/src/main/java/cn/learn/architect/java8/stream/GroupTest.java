package cn.learn.architect.java8.stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ProjectName : architect-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2020年-03月-26日
 */
public class GroupTest {

    public static void main(String[] args){
        Foo f1 = new Foo(1,5);
        Foo f2 = new Foo(3,33);
        Foo f3 = new Foo(3,33);
        List<Foo> fList = new ArrayList<>();
        fList.add(f1);
        fList.add(f2);
        fList.add(f3);
        Map<Integer, IntSummaryStatistics> fooSumMap = fList.stream()
                .collect(Collectors.groupingBy(Foo::getCode,
                        Collectors.summarizingInt(Foo::getCount)));
        for(Map.Entry<Integer, IntSummaryStatistics> fooSum : fooSumMap.entrySet()){
            System.out.println(fooSum.getKey() + "----" + fooSum.getValue().getSum());
        }
    }


    private static class Foo{
        private int code;
        private int count;

        public Foo(int code, int count) {
            this.code = code;
            this.count = count;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
