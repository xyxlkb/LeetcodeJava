public class lc1143_longestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcdd";
        String text2 = "abcd";
        Solution1143 so = new Solution1143();
        System.out.println(so.longestCommonSubsequence(text1,text2));
    }
}
/*1143. 最长公共子序列
中等
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
一个字符串的 子序列 是指这样一个新的字符串：
它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。*/
class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2]; // dp ij 表示text1前i个字符和text2前j个字符的最长公共子序列长度
        if (text1.charAt(0) == text2.charAt(0))
            dp[0][0] = 1;
        else
            dp[0][0] = 0;
        for (int i=1; i<len1; i++) {
            if (text1.charAt(i) == text2.charAt(0))
                dp[i][0] = 1;
            else
                dp[i][0] = dp[i-1][0];
        }
        for (int j=1; j<len2; j++) {
            if (text2.charAt(j) == text1.charAt(0))
                dp[0][j] = 1;
            else
                dp[0][j] = dp[0][j-1];
        }

        for (int i=1; i<len1; i++){
            for (int j=1; j<len2; j++) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[len1-1][len2-1];
    }
}