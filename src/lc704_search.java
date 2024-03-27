public class lc704_search {
    public static void main(String[] args) {
        int a[] = {-1,0,3,5,9,12};
        System.out.println(new Solution704().search(a,13));
    }
}

class Solution704 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            if(nums[0] == target)
                return 0;
            return -1;
        }
        int left = 0;
        int right =  len - 1;
        while(left <= right){
            int mid = (left+right)/2;
            int cur = nums[mid];
            if(cur == target)
                return mid;
            else if(cur < target)
                left = mid+1;
            else if(cur > target)
                right = mid-1;
        }
        return -1;
    }
}
