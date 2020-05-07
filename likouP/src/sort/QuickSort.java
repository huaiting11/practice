package sort;

public class QuickSort {
    int [] a = {1,6,8,7,3,5,16,4,8,36,13,44};
    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        //System.out.println(String.format("qsort() -> low:%s, high:%s", low, high));
        if (low < high) {
            //�������Ϊ������
            int pivot = partition(arr, low, high);
            //�ݹ�������������
            qsort(arr, low, pivot - 1);
            //�ݹ�������������
            qsort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        //�����¼
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            //����������С�ļ�¼�����
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) ++low;
            //����������С�ļ�¼���Ҷ�
            arr[high] = arr[low];
        }
        //ɨ����ɣ����ᵽλ
        arr[low] = pivot;
        //���ص��������λ��
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
