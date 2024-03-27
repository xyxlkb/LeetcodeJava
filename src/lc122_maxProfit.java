public class lc122_maxProfit {
}
// 股票，可以买卖任意多次
class Solution122 {
    // 动态规划，和121题只能买卖一次的差不多
    // dp[i][0]代表第i天持有股票的最大收益
    // dp[i][1]代表第i天不持有股票的最大收益
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i=1; i<len; i++) {
            // 第i天持有股票有两种情况
            // 1.第i-1天持有，今天没卖
            // 2.第i-1天没持有，今天买了，这种情况需要加上dp[i-1][1] 因为可以买卖多次
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);

            // 第i天不持有股票有两种情况
            // 1.第i-1天不持有，今天也没买
            // 2.第i-1天持有，今天卖了
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
        }
        return dp[len-1][1];
    }
    //贪心算法，只取正的利润
//    public int maxProfit(int[] prices) {
//        int profit = 0;
//        int len = prices.length;
//        for (int i=1; i<len; i++)
//            if (prices[i]-prices[i-1] > 0)
//                profit += prices[i] - prices[i-1];
//
//        return profit;
//    }
}