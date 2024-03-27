public class Kuaishou2 {
    public static void main(String[] args) {
        int[] a = {1,2,3,5,6,7};
        System.out.println(findMinNum(a));

    }

    public static int findMinNum(int[] nums) {
        int n = nums.length;

        for (int i=0; i<n; i++) {
            while (nums[i]>0 && nums[i]<n &&
                    nums[nums[i]]!=nums[i]) {
                int t = nums[i];
                int k = nums[nums[i]];
                nums[i] = k;
                nums[t] = t;
            }
            // for (int j=0; j<n; j++)
            //     System.out.print(nums[j]);
        }

        for (int i=1; i<n; i++) {
            if (nums[i] != i)
                return i;
        }
        return n;
    }
}
