public class lc746_minCostClimbingStairs {
    public static void main(String[] args) {
        Solution746 so = new Solution746();
        int[] a = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(so.minCostClimbingStairs(a));
    }
}

class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1)
            return cost[0];
        if (n == 2)
            return Math.min(cost[0], cost[1]);

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<n; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i], dp[i-2]+cost[i]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
}