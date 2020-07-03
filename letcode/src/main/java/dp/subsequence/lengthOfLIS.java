package dp.subsequence;

import java.util.Arrays;

/**
 * 最长递增子序列，的长度。
 * dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
 * 子序列 和 子串这两个名词的区别。子串一定是连续的，而子序列 不一定是连续。
 https://leetcode-cn.com/problems/longest-increasing-subsequence/
   类似的，我们设计动态规划算法，不是需要一个dp 数组吗。 我们可以假设，
 dp[0......1-1] 都已经被
 算出来，然后问自己，怎么通过这些结果算出dp[i]
 输入: [10,9,2,5,3,7,101,18]
 输出: 4
 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

 dp[i] 代表的是以num[i] 为结尾的 最长公共子序列。
  dp 数组应该全部初始化为1，因为子序列最少也要包含自己，所以长度最小为1，
 */
public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
/**
 * dp 的设计流程：
 *
 *  首先明确 dp 数组所存数据的含义，
 *
 *  然后根据dp 数组的定义，运用数学归纳法的思想，假设 dp[0..i-1] 都已经知道，
 *  想办法求出 dp[i], 一旦这一步完成，整个题目基本就解决。
 *
 *  如果无法完成这一步，很可能就是dp 数组的定义不够恰当，需要重新定义dp 数组的含义，
 *  或者可能dp[] 数组
 *
 */
