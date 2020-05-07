package dp.gupai;

/**
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
 * ���ͣ��൱�������Ʊ�ļ۸������ˡ�
 * �ڵ�һ��ʽ�����Ҳ��һ���ģ��൱��������Ʊ�ļ۸��С�ˡ�
 *
 */
public class Kfinitywithfee {
    int maxProfit_with_fee(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
