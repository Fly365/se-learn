package cn.learn.architect.interview.algorithm.sort;

/**
 * ProjectName : architect-learn
 * Description : []
 * 冒泡排序
 * 比较前后相邻的值，如果前面数据大于后面数据，则交换
 * @author : Fly365
 * CreateDate : 2019年-06月-12日
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {9,5,3,7,2,0,1,8,4,5};
        bubbleSort(arr);
        for(int el : arr){
            System.out.print(el + "\t");
        }
    }

    public static void bubbleSort(int[] arr){
        int temp;
        for(int i=0; i< arr.length; i++){
            for(int j=1; j < arr.length-i; j++){
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }



}
