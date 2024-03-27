import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15_threeSum {
    public static void main(String[] args) {
//        int[] a = {-1,0,1,2,0,-1,-4};
        int[] a = {0,0,0,0};
        Solution15 so = new Solution15();
        System.out.println(so.threeSum(a).toString());

    }
}
/*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。*/
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 排序
        for (int i=0; i<=nums.length-3; i++) {
            if (nums[i] > 0) // 如果第一个就大于0了，那么加上后面两个更大的不可能是0，直接结束循环
                break;
            if (i>0 && nums[i]==nums[i-1]) // 这步是去重，如果和前一个数字一样，那么后面找到的两个数字也会一样
                continue; // 但是不能用i和下一个比较，而是该和上一个比较，因为如果和下一个比较，会跳过两个都用的情况，比如-1，-1，2

            int left = i+1;
            int right = nums.length-1; // 双指针，一个在左一个在右
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0)
                    right--;
                else if (nums[i] + nums[left] + nums[right] < 0)
                    left++;
                else { // =0的情况要去重 比如[0,0,0,0]，找到一个之后，第二个0不用找了，所以相同的跳过
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    res.add(item);
                    while (left<right && nums[left]==nums[left+1]) left++;
                    while (left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--; // 这里不用break，因为同一个数字可能可以和后面不同的两个数字组合
                }
            }
        }
        for (List<Integer> item : res) {
        }
        return res;
    }
}
