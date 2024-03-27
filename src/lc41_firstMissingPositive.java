public class lc41_firstMissingPositive {
    public static void main(String[] args) {
        int[] a = {1,2,4,5,6};
        Solution41 so = new Solution41();
        System.out.println(so.firstMissingPositive(a));
//        System.out.println(firstMissingPositive(a));
    }
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i=0; i<n; i++) {
            while (nums[i]>0 && nums[i]<=n &&
                    nums[nums[i]-1]!=nums[i]) {
                int correctIndex = nums[i]-1; // 这个数字应该放在的位置
                int t = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = t;
            }
        }

        for (int i=0; i<n; i++) {
            if (nums[i] != i+1)
                return i+1;
        }

        return n+1;
    }
}
