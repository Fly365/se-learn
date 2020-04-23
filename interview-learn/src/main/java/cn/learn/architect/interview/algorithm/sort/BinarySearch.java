package cn.learn.architect.interview.algorithm.sort;

/**
 * ProjectName : architect-learn
 * Description : []
 * 二分查找，每次与中间的值进行比较
 * @author : Fly365
 * CreateDate : 2019年-06月-12日
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 3));
    }

    /**
     * @param arr 数组
     * @param a 查找值
     * @return 返回索引位置，如果未找到，则返回-1
     */
    public static int binarySearch(int[] arr, int a){
        int low = 0;
        int high = arr.length-1;
        int mid;
        while(low < high){
            mid = (low + high)/2;
            if(arr[mid] == a){
                return mid;
            }else if(arr[mid] > a){
                // 在左侧查找
                high = mid-1;
            }else{
                // 在右侧查找
                low = mid + 1;
            }
        }
        return -1;
    }

}
