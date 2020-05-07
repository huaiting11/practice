package sort;

import javafx.beans.binding.When;

/**
 * 归并排除
 */
public class Sort01 {
    public static void sort(int[] data){
        doSort(data,0,data.length - 1);
    }
    public static void doSort(int[] data, int left,int right){
        if(left >= right) {
            return;
        }
        System.out.println();
        // 找出中间索引
        int center = (left +  right) / 2;
        // 对左边数组进行递归
        doSort(data, left ,center);
        // 对右边数组进行递归
        doSort(data, center + 1, right);
        merge(data, left, center, right);
    }
    /**
     * 将两个数组进行归并，归并前面2 个数组已有序，归并后依然有序。
     *
     *
     */
    private static void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];

        // 右边数组第一个元素索引
        int mid = center + 1;

        // third 记录临时数组的索引
        int third = left;

        // 缓存最数组第一个元素的索引

        int tmp = left;

        while (left <= center && mid <= right){
            if(data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            }else{
                tmpArr[third++] = data[mid++];
            }
        }
        while (mid <= right){
            tmpArr[third++] = data[mid++];
        }
        while (left <= center){
            tmpArr[third++] = data[left++];
        }
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }

    }

}
