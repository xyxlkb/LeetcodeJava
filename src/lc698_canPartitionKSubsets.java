import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class lc698_canPartitionKSubsets {
    public static void main(String[] args) {
        Solution698 so = new Solution698();
        int[] a = {4,3,2,3,5,2,1};
        System.out.println(so.canPartitionKSubsets(a,4));
    }
}

class Solution698 {
    boolean flag;
    int target;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=0; i<n/2; i++) { // 先从大到小排序
            int t = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-1-i] = t;
        }
        int tot = 0;
        for (int i=0; i<n; i++)
            tot += nums[i];
        if (tot%k != 0)
            return false;
        target = tot/k;
        int[] sum = new int[k]; // 记录k个分组各自的和

        flag = false;
        backtrack(nums, sum, 0);
        return flag;
    }
    // seq是目前用到第seq个数字，k是总共分k组
    public void backtrack(int[] nums, int[] sum, int seq) {
        if (flag)
            return;
        if (seq == nums.length)
            return;
        for (int i=0; i<sum.length; i++) {
            sum[i] += nums[seq];
            if (sum[i] > target) { // 如果已经大于target，就没必要往下回溯
                sum[i] -= nums[seq];
                continue;
            }
            if (isFinished(sum)) {
                flag = true;
                return;
            }
            backtrack(nums, sum, seq+1);
            sum[i] -= nums[seq];
        }
    }
    public boolean isFinished(int[] sum) {
        for (int i=0; i<sum.length; i++)
            if (sum[i] != target)
                return false;
        return true;
    }
}