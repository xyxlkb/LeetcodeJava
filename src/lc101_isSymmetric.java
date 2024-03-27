import javax.swing.text.StyledEditorKit;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc101_isSymmetric {
}
/*给你一个二叉树的根节点 root ， 检查它是否轴对称*/
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        // 思路：比较root的左右两个子树，用前面写过的翻转二叉树代码把其中一个子树翻转，然后比较两个是否一样
        if (root == null)
            return true;
        if (root.left==null && root.right==null)
            return true;
        if (root.left==null && root.right!=null)
            return false;
        if (root.left!=null && root.right==null)
            return false;
        boolean flag = true;

        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        rightRoot = invertTree(rightRoot);
        return compareTree(leftRoot,rightRoot);
    }

    public boolean compareTree(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot==null && rightRoot==null)
            return true;
        if (leftRoot==null)
            return false;
        if (rightRoot==null)
            return false;
        if (leftRoot.val != rightRoot.val)
            return false;
        return compareTree(leftRoot.left,rightRoot.left) && compareTree(leftRoot.right,rightRoot.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        // 还是用层序遍历的方法吧
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

            if (cur.left==null && cur.right==null)
                continue;
            else if (cur.left == null) {
                cur.left = cur.right;
                cur.right = null;
            }
            else if (cur.right == null) {
                cur.right = cur.left;
                cur.left = null;
            }
            else {
                TreeNode t = cur.left;
                cur.left = cur.right;
                cur.right = t;
            }
        }
        return root;
    }
}
