public class lc718_findLength {
    public static void main(String[] args) {
        int[] a = {1,2,3,2,8};
        int[] b = {5,6,1,4,7};
        Solution718 so = new Solution718();
        System.out.println(so.findLength(a,b));
    }
}
/*718. 最长重复子数组  中等   就是最长公共子串
给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
示例 1：
输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
输出：3
解释：长度最长的公共子数组是 [3,2,1] 。
示例 2：
输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
输出：5*/
class Solution718 {
    public int findLength(int[] nums1, int[] nums2) {
        int maxLength = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1][len2];
        for (int i=0; i<len1; i++)
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                maxLength = 1;
            }

        for (int j=0; j<len2; j++)
            if (nums2[j] == nums1[0]) {
                dp[0][j] = 1;
                maxLength = 1;
            }


        for (int i=1; i<len1; i++)
            for (int j=1; j<len2; j++) {
                if (nums1[i] ==nums2[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = 0;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        return maxLength;
    }
}