import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc199_rightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution199 so = new Solution199();
        List<Integer> res = so.rightSideView(root);
        System.out.println(res);

    }
}

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res  = new ArrayList<>();
        if (root == null)
            return res;
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
                res.add(cur.val);
                curNum = queue.size();
            }
        }

        return res;
    }
}
