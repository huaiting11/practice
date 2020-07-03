package sort;

public class QuickSort1 {
    /**
     * ¿ìÅÅ¡£
     */
    int [] a = {1,6,8,7,3,5,16,4,8,36,13,44};
    public static  void sort(int[] array){
        quickSort(array, 0 ,array.length -1 );
    }
    public static void quickSort(int[] array, int begin ,int end) {
        if(end <= begin) return;
        int pivot = partition(array, begin ,end);
        quickSort(array, begin ,pivot -1 );
        quickSort(array, pivot+ 1, end);
    }
    private static int partition(int[] a, int begin, int end) {
        int pivot = end , counter = begin;
        for (int i = begin; i < end ; i++) {
            if(a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }
    public static void main(String[] args) {
        QuickSort1 pai = new QuickSort1();
        pai.sort(pai.a);
        for (int i = 0; i < pai.a.length; i++) {
            System.out.println(pai.a[i]);
        }
    }
}
