package sort;

/**
 * 给定一个数组?nums?，如果?i < j?且?nums[i] > 2*nums[j]?我们就将?(i, j)?称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 * nums[i] > 2*nums[j]
 */
public class Q493 {
    /**
     * 暴力的方法
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
