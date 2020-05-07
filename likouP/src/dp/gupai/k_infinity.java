package dp.gupai;

/**
 * ��� k Ϊ�������ô�Ϳ�����Ϊ k �� k - 1 ��һ���ġ�����������д��ܣ�
 */
public class k_infinity {
    /**
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
     * <p>
     * ���Ƿ��������е� k �Ѿ�����ı��ˣ�Ҳ����˵����Ҫ��¼ k ���״̬�ˣ�
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     */
    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
