package cn.learn.architect.interview.annotation.demo01;

import java.lang.reflect.Field;

/**
 * ProjectName : architect-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-06月-12日
 */
public class FruitInfoUtil {

    public static void getFruiltInfo(Class<?> clazz){
        String fruitInfo = null;
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                fruitInfo = "id=" + fruitProvider.id() + ",name=" + fruitProvider.name()
                        + ",address=" + fruitProvider.address();
                System.out.println(fruitInfo);
            }
        }
    }


}
