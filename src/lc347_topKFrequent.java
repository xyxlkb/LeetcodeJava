import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc347_topKFrequent {
    public static void main(String[] args) {
        Solution347 so = new Solution347();
        int[] nums = {1,1,1,2,2,3,3,3,3};
        int[] a = so.topKFrequent(nums,2);
        for (int i : a)
            System.out.println(i);
    }
}
/*给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]*/
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count  = new HashMap<>(); // 统计nums数组里每个数出现的次数
        for (int i : nums) {
            if (count.containsKey(i))
                count.put(i, count.get(i)+1); // 把i这个数的次数+1 注意map里面同一个key只能出现一次，所以put一个新的相当于重新赋值这个键值对
            else
                count.put(i, 1);
        }

        // 新建一个小顶堆，存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数，都要存，因为返回的是数字，比较的是次数
        // 出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
        for(Map.Entry<Integer,Integer> entry:count.entrySet()){ //遍历每一个键值对
            if(pq.size()<k)//小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(),entry.getValue()}); // 小顶堆存的是数组
            else {
                if(entry.getValue()>pq.peek()[1]){ // 当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                    pq.poll();// 弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}