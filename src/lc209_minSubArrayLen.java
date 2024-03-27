public class lc209_minSubArrayLen {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Solution209 so = new Solution209();
        System.out.println(so.minSubArrayLen(11,a));
    }
}

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0; // try if there is no satisfied array
        for(int i=0; i<len; i++)
            sum += nums[i];
        if(sum < target)
            return 0;

        int left = 0;
        int right = 0;
        sum = 0;
        int minlen = len; //  min array length
        while (right < len) {
            sum += nums[right];
            while(sum >= target) {
                if(right-left+1 < minlen)
                    minlen = right-left+1;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minlen;
    }

//    public int subArraySum(int left, int right, int[] nums) { // this cost too much time! don't need to calculate every time
//        int sum = 0;
//        for(int i=left; i<=right; i++)
//            sum += nums[i];
//        return sum;
//    }
}