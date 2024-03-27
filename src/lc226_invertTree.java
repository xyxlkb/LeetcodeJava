import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc226_invertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution226 so = new Solution226();
        root = so.invertTree(root);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left);
    }
}

class Solution226 {
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
