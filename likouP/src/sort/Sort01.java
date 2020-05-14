package sort;

import javafx.beans.binding.When;

/**
 * ¹é²¢ÅÅ³ý
 */
public class Sort01 {
    public static void sort(int[] data){
        //doSort(data,0,data.length - 1);
    }
    public static void mergeSort(int[] array, int left, int right) {
        if(right <= left ) return;
        int mid = (left + right) >> 1 ; // £¨left + right) /2 
        mergeSort(array, left ,mid);
        mergeSort(array, mid + 1,right);
        merge(array, left, mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
    }


}
