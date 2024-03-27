import java.lang.invoke.CallSite;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc515_largestValues {
}

class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 1;
        int curMax = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val > curMax)
                curMax = cur.val;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

            curNum--;
            if (curNum == 0) {
                res.add(curMax);
                curMax = Integer.MIN_VALUE;
                curNum = queue.size();
            }
        }
        return res;
    }
}