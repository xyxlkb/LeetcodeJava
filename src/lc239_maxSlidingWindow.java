import java.util.*;

public class lc239_maxSlidingWindow {
    public static void main(String[] args) {
        Solution239 so = new Solution239();
        int[] a = {1,3,-1,-3,5,3,6,7};
        int[] res = so.maxSlidingWindow(a,3);
        for (int i=0; i<res.length; i++)
            System.out.print(res[i] + "  ");
    }
}
/*给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。 */

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        decreasingQueue queue = new decreasingQueue();
        int left = 0;
        int right = k-1;
        for (int i=left; i<=right; i++)
            queue.push(nums[i]);
        res.add(queue.peek()); // 最开始这个区间的最大值，就是队列的第一个
        while (right < nums.length-1) {
            queue.pop(nums[left]);
            queue.push(nums[right+1]);
            res.add(queue.peek());
            left++;
            right++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
//        下面是用大根堆的方法，时间复杂度太高
//        ArrayList<Integer> res = new ArrayList<>();
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 大根堆
//        int left = 0;
//        int right = k-1;
//        for (int i=left; i<=right; i++)
//            maxHeap.add(nums[i]);
//        res.add(maxHeap.peek()); // 最上面的就是目前的max
//        while (right < nums.length-1) {
//            maxHeap.remove(nums[left]);
//            maxHeap.add(nums[right+1]);
//            res.add(maxHeap.peek());
//            left++;
//            right++;
//        }
//        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // 单调递减队列，队列的第一个元素是最大值，内部递减
    class decreasingQueue {
        Deque<Integer> deque; // 用一个双端队列实现，可以从队尾出队
        decreasingQueue() {
            deque = new ArrayDeque<>();
        }

        // 队列里只需要维护可能成为max的数就行，其他的全部忽略
        public void push(int k) {
            if (deque.size() == 0)  // 如果没有元素，就直接插入
                deque.add(k);
            else if (k > deque.peek()) { // 插入元素时如果元素大于第一个，那就清空队列，插入这个最大值
                deque.clear();
                deque.add(k);
            }
            else { // 如果插入元素小于第一个，就从队列最后开始比较，把小于插入值的都弹出，从后面插入
                while (deque.peekLast() < k)
                    deque.removeLast();
                deque.add(k);
            }
        }
        // 要弹出的元素如果是队列第一个，就弹出，否则忽视
        public int pop(int k){
            if (deque.size()==0 || deque.peek()!=k)
                return 0;
            else
                return deque.poll();
        }
        public int peek(){
            return deque.peek();
        }
    }
}