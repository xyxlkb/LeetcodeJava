public class lc53_maxSubArray {
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i=0; i<dp.length; i++)
            if (dp[i] > max)
                max = dp[i];

        return max;

//        boolean flag = true; // 是否全是负数
//        int max = Integer.MIN_VALUE;
//        for (int i=0; i<nums.length; i++) {
//            if (nums[i] > 0)
//                flag = false;
//            if (nums[i] > max)
//                max = nums[i];
//        }
//        if (flag)
//            return max;
//
//        max = 0;
//        int curMax = 0;
//        for (int i=0; i<nums.length; i++) {
//            curMax += nums[i];
//            if (curMax < 0)
//                curMax = 0;
//            else if (curMax > max)
//                max = curMax;
//        }
//
//        return max;
    }
}