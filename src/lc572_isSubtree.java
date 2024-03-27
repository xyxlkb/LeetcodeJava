import java.util.LinkedList;
import java.util.Queue;

public class lc572_isSubtree {
}

class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (compareTree(cur, subRoot))
                return true;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return false;
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
}