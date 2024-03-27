public class lc96_numTrees {
    public static void main(String[] args) {
        Solution96 so = new Solution96();
        System.out.println(so.numTrees(4));
    }
}

class Solution96 {
    public int numTrees(int n) {
        int[] dp = new int[20];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i=4; i<=n; i++) {
            for (int t=0; t<i; t++)
                dp[i] += dp[t]*dp[i-t-1];
        }
        return dp[n];
    }
}