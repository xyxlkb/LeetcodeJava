import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc349_intersection {
    public static void main(String[] args) {
        Solution349 so = new Solution349();
        int[] a = {1,2,2,1};
        int[] b = {2,1};
        int[] res = so.intersection(a,b);
//        System.out.println(res.length);
        for (int i=0;i<res.length;i++)
            System.out.println(res[i]);

    }
}

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] flag1 = new int[1001]; // flag[i]=1 表示i这个数字在nums1中出现过
        int[] flag2 = new int[1001];
        Arrays.fill(flag1, 0); // 清零
        Arrays.fill(flag2, 0);

//        ArrayList<Integer> res = new ArrayList<Integer>(); // 结果数组
        Set<Integer> res = new HashSet<>(); // 用set存，可以防止重复

        for (int i=0; i<nums1.length; i++) {
//            System.out.println(nums1[i]);
            flag1[nums1[i]] = 1;
        }
        for (int i=0; i<nums2.length; i++)
            flag2[nums2[i]] = 1;
        for (int i=0; i<=1000; i++) {
            if (flag2[i]!=0 && flag1[i]!=0) {
//                System.out.println(i);
                res.add(i);
            }
        }
//        System.out.println(res.toString());
        return  res.stream().mapToInt(Integer::intValue).toArray();
    }
}
