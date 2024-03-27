import java.util.ArrayList;
import java.util.Arrays;
import java.util.FormattableFlags;
import java.util.List;

public class lc18_fourSum {
    public static void main(String[] args) {
        int[] a = {1000000000,1000000000,1000000000,1000000000};
//        int[] a = {0,0,0,0};
        Solution18 so = new Solution18();
        System.out.println(so.fourSum(a,-294967296).toString());

    }
}
/*给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。* */
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        // 参考三数之和，别的都一样，就是外层循环变成双重的，三数是把复杂度从3重降到1重，这个是4重降到2重
        for (int i=0; i<=len-4; i++)
            for (int j=i+1; j<=len-3; j++) {
                if (i>0 && nums[i]==nums[i-1]) // 跟3数一样，如果和前一个相同就跳过，防止重复
                    continue;
                if (j>i+1 && nums[j]==nums[j-1])
                    continue;

                int left = j+1;
                int right = len-1;
                while (left < right) {
                    if ((long) nums[i]+nums[j]+nums[left]+nums[right] > (long) target)
                        right--;
                    else if ((long) nums[i]+nums[j]+nums[left]+nums[right] < (long) target)
                        left++;
                    else {
                        System.out.println(nums[i]+nums[j]+nums[left]+nums[right]);
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[left]);
                        item.add(nums[right]);
                        res.add(item);
                        while (left<right && nums[left]==nums[left+1]) left++;
                        while (left<right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        return res;
    }
}
