public class lc121_maxProfit {
}

class Solution121 {
    // 动态规划
    // dp[i][0]代表第i天持有股票的最大收益
    // dp[i][1]代表第i天不持有股票的最大收益
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i=1; i<n; i++) {
            //第i天持有股票有两种可能
            //1. 第i-1天就持有，今天没卖
            //2. 第i-1天不持有，今天买了
            //因为股票全程只能买卖一次，所以如果买入股票，那么第i天持有股票即dp[i][0]一定就是 -prices[i]。
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);

            //第i天不持有股票有两种可能
            //1.第i-1天就不持有，今天没买
            //2.第i-1天持有，今天卖了
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
        }

        return dp[n-1][1];
    }



    //贪心法，不用动态规划
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int minPrice = prices[0];
//        int n = prices.length;
//        for (int i=1; i<n; i++) {
//            if (prices[i]-minPrice > maxProfit)
//                maxProfit = prices[i]-minPrice;
//            if (prices[i] < minPrice)
//                minPrice = prices[i];
//        }
//        return maxProfit;
//    }
}