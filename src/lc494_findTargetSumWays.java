import java.sql.SQLOutput;

public class lc494_findTargetSumWays {
    public static void main(String[] args) {
        Solution494 so = new Solution494();
        int[] a = {1,1,1,1,1};
        System.out.println(so.findTargetSumWays(a,3));
    }
}

class Solution494 {
    int count = 0; // 回溯法，统计次数
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length){// 只有每一个数字用完了才判断sun是不是等于target
            if (sum == target)
                count++;
        }
        else {
            backtrack(nums, target, index+1, sum+nums[index]);
            backtrack(nums, target, index+1, sum-nums[index]);
        }
    }
}
