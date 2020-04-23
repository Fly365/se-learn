package cn.learn.architect.interview.algorithm.sort;

/**
 * ProjectName : architect-learn
 * Description : []
 * 构建有序序列，对于未排序数据，
 * 在已排序序列中[从后向前]扫描，找到相应的位置并插入。
 * @author : Fly365
 * CreateDate : 2019年-06月-12日
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {9,5,3,7,2,0,1,8,4,5};
        insertionSort(arr);
        for(int el : arr){
            System.out.print(el + "\t");
        }
    }

    public static void insertionSort(int[] arr){
        //从第一个元素，开始进行排序
        int insertVal,compIndex;
        for(int i=1; i<arr.length;i++){
            insertVal = arr[i];
            // compIndex 为已经排序好的元素的索引最大值
            compIndex = i-1;
            while (compIndex >= 0 && insertVal < arr[compIndex]){
                // 元素先后移动
                arr[compIndex+1] = arr[compIndex];
                compIndex--;
            }
            arr[compIndex+1] = insertVal;
        }
    }

}
