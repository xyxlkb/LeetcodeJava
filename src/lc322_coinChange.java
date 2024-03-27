public class lc322_coinChange {
    public static void main(String[] args) {
        int[] coins = {2};
        Solution322 so = new Solution322();
        System.out.println(so.coinChange(coins,1));
    }
}

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        int[] dp = new int[amount+1];
        for (int i=0; i<amount+1; i++)
            dp[i] = Integer.MAX_VALUE-1;
        boolean flag = false; // 判断amount是不是比所有的coin都小
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
                flag = true;
            }
        }
        if (!flag)
            return -1;
        for (int i=1; i<=amount; i++) {
            for (int coin : coins) {
                if (i-coin >= 0)
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }

        if (dp[amount] == Integer.MAX_VALUE-1)
            return -1;
        else
            return dp[amount];
    }
}
