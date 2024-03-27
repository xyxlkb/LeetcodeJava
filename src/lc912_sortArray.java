import java.io.PipedOutputStream;
import java.util.Random;

public class lc912_sortArray {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        Solution912 so = new Solution912();
        so.sortArray(arr);
        for (int i=0; i<arr.length; i++)
            System.out.println(arr[i]);

    }
}
// 快排
class Solution912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);

        return nums;
    }
    public static void quickSort (int[] nums, int left, int right) {
        if (left < right) {
            //先随机选一个位置，和最左边的位置交换，当作pivot
//            int randomIndex = new Random().nextInt(right - left + 1) + left;
//            int t = nums[left];
//            nums[left] = nums[randomIndex];
//            nums[randomIndex] = t;

            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot-1);
            quickSort(nums, pivot+1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            //因为是用最左边的元素当作pivot，所以要从右边开始找小于pivot的，放到最左边，这个元素内容已经被记录在pivot里了，不怕覆盖
            while (left<right && nums[right]>=pivot)
                right--;
            nums[left] = nums[right];

            while (left<right && nums[left]<=pivot)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;

        return left;
    }
}