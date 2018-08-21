package cn.learn.se.effective.ch02;

/**
 * effective-java-cn.learn.se.effective.ch02
 * 遇到多个构造器参数时考虑使用 构建器
 * 示例 包装食品外面显示的营养成分标签
 * 标签中几个域：每份含量、每罐含量以及每份卡里路为必须
 * 总脂肪、饱和脂肪量、转化脂肪、胆固醇、钠等约20个域是可选的
 * @author : WXF
 * @date : 2018年-08月-21日
 */
public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private static class Builder {
        //必要的参数
        private final int servingSize;
        private final int servings;

        //可选参数
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }
        public Builder fat(int val){
            fat = val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }
        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    //私有构造
    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }


    public static void main(String[] args){
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8)
                .calories(100).sodium(35).carbohydrate(27).build();

        System.out.println(cocaCola);
    }

}
