package sort;

import javafx.beans.binding.When;

/**
 * �鲢�ų�
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
        // �ҳ��м�����
        int center = (left +  right) / 2;
        // �����������еݹ�
        doSort(data, left ,center);
        // ���ұ�������еݹ�
        doSort(data, center + 1, right);
        merge(data, left, center, right);
    }
    /**
     * ������������й鲢���鲢ǰ��2 �����������򣬹鲢����Ȼ����
     *
     *
     */
    private static void merge(int[] data, int left, int center, int right) {
        // ��ʱ����
        int[] tmpArr = new int[data.length];

        // �ұ������һ��Ԫ������
        int mid = center + 1;

        // third ��¼��ʱ���������
        int third = left;

        // �����������һ��Ԫ�ص�����

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
