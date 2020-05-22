package sort;

import java.awt.*;

public class QuickSort {
    int [] a = {1,6,8,7,3,5,16,4,8,36,13,44};
    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if(low > high ) return;
        int part = partition(arr,low, high);
        qsort(arr, low , part -1);
        qsort(arr, part + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
       int pov = high, count = low;
        for (int i = low; i < high; i++) {
            if(arr[i] < arr[pov]) {
               int temp = arr[count];
               arr[count ] = arr[i];
               arr[i] = temp;
               count++;
            }
        }
        int temp = arr[pov] ; arr[pov] = arr[count]; arr[count] = temp;
        return count;
    }

    public static void main(String[] args) {
        QuickSort pai = new QuickSort();
        pai.quickSort(pai.a);
        for (int i = 0; i < pai.a.length; i++) {
            System.out.println(pai.a[i]);
        }
    }
}
