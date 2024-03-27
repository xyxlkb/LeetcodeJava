import java.util.HashMap;
import java.util.Map;

public class lc454_fourSumCount {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {-1,-2};
        int[] c = {-1,2};
        int[] d = {0,2};
        Solution454 so = new Solution454();
        System.out.println(so.fourSumCount(a,b,c,d));

    }
}
/*给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0* */
class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int cnt = 0;
        // 思路是1和2双重循环一次，3和4双重循环一次，时间复杂度会变成n方
        // 循环12的时候记录所有出现过的值，存在key，这个值出现的次数存在value
        // 循环34的时候看看需要的差是否在map中存在，存在就cnt++
        Map<Integer, Integer> sum = new HashMap<>();
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++) {
                int t = nums1[i] + nums2[j];
                if (sum.containsKey(t)) // 如果这个值已经有过
                    sum.put(t, sum.get(t)+1); // t出现的次数+1
                else
                    sum.put(t,1); // 没有过的话就加入map
            }
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++) {
                int t = nums3[i] + nums4[j];
                t = -t;
                if (sum.containsKey(t)) // 需要的差如果出现过，就增加次数
                    cnt += sum.get(t);
            }
        return cnt;

//        int n = nums1.length;
//        int cnt = 0;
//        四重循环暴力
//        for (int i=0; i<n; i++)
//            for (int j=0; j<n; j++)
//                for (int k=0; k<n; k++)
//                    for (int l=0; l<n; l++)
//                        if (nums1[i]+nums2[j]+nums3[k]+nums4[l] == 0)
//                            cnt++;
//        return cnt;
    }
}
