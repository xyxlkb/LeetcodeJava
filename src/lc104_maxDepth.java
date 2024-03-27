import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc104_maxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution104 so = new Solution104();
        System.out.println(so.maxDepth(root));

    }
}
class Solution104 {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

            curNum--;
            if (curNum == 0) {
                depth++;
                curNum = queue.size();
            }
        }
        return depth;
    }
}
