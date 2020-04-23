package cn.learn.architect.interview.annotation.demo01;

/**
 * ProjectName : architect-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-06月-12日
 */
public class Apple01 {

    @FruitProvider(id = 1,name = "红富士",address = "北京")
    private String appleProvider;

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }
}
