package sort;

public class Sort {
    /**
     * �鲢����
     */
    int [] a = {1,6,8,7,3,5,16,4,8,36,13,44};
    public static void sort(int[] data) {
        doSort(data, 0, data.length - 1);
    }

    public static void doSort(int[] data, int left, int right) {
        if (left >= right)
            return;
        System.out.println();
        // �ҳ��м�����
        int center = (left + right) / 2;
        // �����������еݹ�
        doSort(data, left, center);
        // ���ұ�������еݹ�
        doSort(data, center + 1, right);
        // �ϲ�
        merge(data, left, center, right);
    }

    /**
     * ������������й鲢���鲢ǰ��2�����������򣬹鲢����Ȼ����
     *
     * @param data
     *            �������
     * @param left
     *            ������ĵ�һ��Ԫ�ص�����
     * @param center
     *            ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص�����
     * @param right
     *            ���������һ��Ԫ�ص�����
     */
    private static void merge(int[] data, int left, int center, int right) {
        System.out.println(String.format("->\nleft:%s,center:%s,right:%s\nbefore:", left, center, right));
       // Util.printArray(data);
        // ��ʱ����
        int[] tmpArr = new int[data.length];
        // �������һ��Ԫ������
        int mid = center + 1;
        // third ��¼��ʱ���������
        int third = left;
        // �����������һ��Ԫ�ص�����
        int tmp = left;
        while (left <= center && mid <= right) {
            // ������������ȡ����С�ķ�����ʱ����
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // ����ʱ�����е����ݿ�����ԭ������
        // ��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
        System.out.println("\nafter:");
       // Util.printArray(data);
        System.out.println("\n<-\n\n");
    }

    public static void main(String[] args) {
        Sort pai = new Sort();
        pai.sort(pai.a);
        for (int i = 0; i < pai.a.length; i++) {
            System.out.println(pai.a[i]);
        }
    }

}
