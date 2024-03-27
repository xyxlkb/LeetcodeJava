public class lc509_fib {
    public static void main(String[] args) {
        Solution509 so = new Solution509();
        System.out.println(so.fib(0));
    }
}

class Solution509 {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=n; i++)
            dp[i] = dp[i-1] +dp[i-2];
        return dp[n];
    }
//    递归做法
//    public int fib(int n) {
//        return recursion(n);
//    }
//    public int recursion(int n) {
//        if (n == 0)
//            return 0;
//        if (n == 1)
//            return 1;
//        return recursion(n-1) + recursion(n-2);
//    }
}