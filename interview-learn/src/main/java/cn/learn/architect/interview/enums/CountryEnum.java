package cn.learn.architect.interview.enums;

import lombok.Getter;

/**
 * ProjectName : interview-learn
 * Description : []
 * @author : Fly365
 * CreateDate : 2019年-05月-19日
 */
public enum CountryEnum {

    one(1,"齐"),two(2,"楚"),three(3,"燕"),four(4,"赵"),five(5,"魏"),six(6,"韩");

    @Getter private Integer retCode;
    @Getter private String retMsg;

    CountryEnum(Integer retCode, String retMsg){
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public static CountryEnum getCountryEnum(int index){
        CountryEnum[] enumArr = CountryEnum.values();
        for(CountryEnum countryEnum : enumArr){
            if(countryEnum.retCode == index){
                return countryEnum;
            }
        }
        return null;
    }

}
