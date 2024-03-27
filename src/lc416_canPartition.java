import java.awt.font.NumericShaper;
import java.util.Arrays;

public class lc416_canPartition     {
    public static void main(String[] args) {
//        Solution416 so = new Solution416();
//        int[] a = {1,2,3,5,1};
//        System.out.println(so.canPartition(a));
    }
}


class Solution416 {
//    public boolean canPartition(int[] nums) {
//        int n = nums.length;
//        if (n==0 || n==1)
//            return false;
//        int sum = 0;
//        for (int i=0; i<n; i++)
//            sum += nums[i];
//        if (sum%2 != 0)
//            return false;
//        int target = sum/2;
//
//
//
//    }
    
//    下面是回溯法，会超时
//    boolean flag;
//    public boolean canPartition(int[] nums) {
//        int n = nums.length;
//        if (n==0 || n==1)
//            return false;
//        int sum = 0;
//        for (int i=0; i<n; i++)
//            sum += nums[i];
//        if (sum%2 != 0)
//            return false;
//        int target = sum/2;
//        flag = false;
//        Arrays.sort(nums);
//        for (int i=0; i<n/2; i++) {
//            int t = nums[i];
//            nums[i] = nums[n-1-i];
//            nums[n-1-i] = t;
//        }
//        backtrack(nums, 0, 0, target);
//        return flag;
//    }
//
//    public void backtrack(int[] nums, int k, int sum, int target) {
//        if (flag)
//            return;
//        if (sum > target)
//            return;
//        if (k == nums.length)
//            return;
//        if (sum == target) {
//            flag = true;
//            return;
//        }
//
//        backtrack(nums,k+1, sum+nums[k], target);
//        backtrack(nums,k+1, sum, target);
//    }
}
