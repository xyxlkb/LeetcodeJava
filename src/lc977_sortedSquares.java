/*
 *给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * */
public class lc977_sortedSquares {
    public static void main(String[] args) {
        int[] a = {-4,-1,0,3,10};
        Solution977 so = new Solution977();
        a = so.sortedSquares(a);
        for(int i=0; i<a.length; i++)
            System.out.println(a[i]);
    }
}

class Solution977 {
    public int[] sortedSquares(int[] nums) { // 双指针法
        int len = nums.length;
        int[] result = new int[len];
        len--;
        int left = 0;
        int right = len;
        while(left <= right) {
            if((nums[left] *nums[left]) > nums[right] * nums[right]) {
                result[len--] = nums[left] *nums[left];
                left++;
            }
            else {
                result[len--] = nums[right] *nums[right];
                right--;
            }
        }
        return result;
    }
}
