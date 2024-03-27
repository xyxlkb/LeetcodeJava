public class lc70_climbStairs {
    public static void main(String[] args) {
        Solution70 so = new Solution70();
        System.out.println(so.climbStairs(1));
    }
}

class Solution70 {
    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++)
            dp[i] = dp[i-1] +dp[i-2];
        return dp[n];
    }
}