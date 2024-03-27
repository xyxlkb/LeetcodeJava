public class lc123_maxProfit {
}
// 股票交易，只能买卖两次
class Solution123 {
    public int maxProfit(int[] prices) {
//        一天一共就有4个状态，dp[i][j] 表示第i天第j种状态下持有的钱
//        0.第一次持有股票  不一定是第i天买，可能是前几天买的，但是到现在一直没卖
//        1.第一次不持有股票
//        2.第二次持有股票
//        3.第二次不持有股票
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for (int i=1; i<len; i++) {
            //第i天第一次持有  可能是
            //1.第i-1天第一次持有，今天没卖
            //2.第i-1天第一次不持有，今天买了  这是第一次买，所以就是-prices[i]，和只能买一次的一样
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            //第i天第一次不持有  可能是：
            //1.第i-1天第一次不持有，今天没买
            //2.第i-1天第一次持有，今天卖了
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
            //第i天第二次持有  可能是：
            //1.第i-1天第一次不持有，今天买了  这是第二次买，需要加上之前不持有时候的钱
            //2.第i-1天第二次持有，今天没卖
            dp[i][2] = Math.max(dp[i-1][1]-prices[i], dp[i-1][2]);
            //第i天第二次不持有  可能是：
            //1.第i-1天第二次不持有，今天没买
            //2.第i-1天第二次持有，今天卖了
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2]+prices[i]);
        }

        return dp[len-1][3];
    }
}