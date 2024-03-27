/*给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
返回 你可以获得的最大乘积 。
示例 1:
输入: n = 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:
输入: n = 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。*/
public class lc343_integerBreak {
    public static void main(String[] args) {
        Solution343 so = new Solution343();
        System.out.println(so.integerBreak(2));
    }
}

class Solution343 {
    public int integerBreak(int n) {
        if (n==3)
            return 2;
        int[] dp = new int[60];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 6;
        for (int i=6; i<=n; i++) {
            int max = 0;
            for (int left=2; left<=i/2; left++) {
                int right = i-left;
                if (dp[left]*dp[right] > max)
                    max = dp[left]*dp[right];
            }
            dp[i] = max;
        }

        return dp[n];
    }
}