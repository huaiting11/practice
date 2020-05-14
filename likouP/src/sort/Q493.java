package sort;

/**
 * ����һ������?nums?�����?i < j?��?nums[i] > 2*nums[j]?���Ǿͽ�?(i, j)?����һ����Ҫ��ת�ԡ�
 *
 * ����Ҫ���ظ��������е���Ҫ��ת�Ե�������
 * nums[i] > 2*nums[j]
 */
public class Q493 {
    /**
     * �����ķ���
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int totals = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                long m  = nums[k];
                if(nums[i] > (m * 2)) {
                    totals++;
                }
            }
        }
        return totals;
    }

    public static void main(String[] args) {
        int[] m = new int[] {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        Q493 q493 = new Q493();
        int i = q493.reversePairs(m);
        System.out.println(i);

    }
}
