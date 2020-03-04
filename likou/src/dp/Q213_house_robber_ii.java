package dp;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Q213_house_robber_ii {
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int[] circutBreaker1 = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] circutBreaker2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(robSub(circutBreaker1), robSub(circutBreaker2));
    }

    private int robSub(int[] nums) {
        int[] dp = new int[nums.length+2];
        dp[0]=0;
        dp[1]=0;
        for (int i=2; i<dp.length; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
