import java.security.spec.ECField;

import static java.util.Collections.max;

public class lc42_trap {
    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution42 so = new Solution42();
        System.out.println(so.trap(a));
    }
}

class Solution42 {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] leftMax = new int[n]; // 某列左边的列中最高的高度
        int[] rightMax = new int[n];

        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
        }
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
        }

        for (int i=1; i<=n-2; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > height[i])
                sum += minHeight - height[i];
        }

        return sum;
    }
}