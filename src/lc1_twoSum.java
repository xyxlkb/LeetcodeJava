import java.util.HashMap;
import java.util.Map;

public class lc1_twoSum {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int target = 8;
        Solution1 so = new Solution1();
        int[] res = so.twoSum(a,target);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。* */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        // 每次搜索一个数的时候查找map里是否有可以跟他配合的数，没有的话，就把这个数放进map
        // 所以map同时要记录数的内容和下标，key存内容，value存下标
        Map<Integer, Integer> searched = new HashMap<>();
        for (int i=0; i<n; i++) {
            int diff = target - nums[i]; // 差
            if (searched.containsKey(diff)) { // 如果差已经被找过了
                res[0] = i;
                res[1] = searched.get(diff); // 差的下标
            }
            searched.put(nums[i], i);
        }
        return res;
//        下面这个是暴力解法，双重循环
//        int[] res = new int[2];
//        int n = nums.length;
//        for(int i=0; i<n-1; i++){
//            int k = target - nums[i];
//            for(int j=i+1; j<n; j++)
//                if(nums[j] == k){
//                    res[0] = i;
//                    res[1] = j;
//                    return res;
//                }
//        }
//        return res;
    }
}