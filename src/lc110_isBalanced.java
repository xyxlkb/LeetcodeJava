import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.abs;

public class lc110_isBalanced {
}
/*给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。*/
class Solution110 {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        preorderRecursion(root);
        return flag;
    }

    public void preorderRecursion(TreeNode root) { // 递归看每一个节点是否平衡
        if (root == null)
            return;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) >1)
            flag = false;
        preorderRecursion(root.left);
        preorderRecursion(root.right);
    }

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