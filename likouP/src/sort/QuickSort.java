package sort;

public class QuickSort {
    int [] a = {1,6,8,7,3,5,16,4,8,36,13,44};
    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        //System.out.println(String.format("qsort() -> low:%s, high:%s", low, high));
        if (low < high) {
            //将数组分为两部分
            int pivot = partition(arr, low, high);
            //递归排序左子数组
            qsort(arr, low, pivot - 1);
            //递归排序右子数组
            qsort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        //枢轴记录
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            //交换比枢轴小的记录到左端
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) ++low;
            //交换比枢轴小的记录到右端
            arr[high] = arr[low];
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    public static void main(String[] args) {
        QuickSort pai = new QuickSort();
        pai.quickSort(pai.a);
        for (int i = 0; i < pai.a.length; i++) {
            System.out.println(pai.a[i]);
        }
    }
}
