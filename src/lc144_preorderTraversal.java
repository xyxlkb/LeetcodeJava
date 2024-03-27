import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc144_preorderTraversal {
    public static void main(String[] args) {
        Solution144 so = new Solution144();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(so.preorderTraversal(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
class Solution144 { // 前序遍历
    // 这个是迭代法
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return res;

        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
        return res;
    }
//    下面是递归法
//    ArrayList<Integer> res = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        preorderRecursion(root);
//        return res;
//    }
//
//    public void preorderRecursion(TreeNode root) {
//        if (root == null)
//            return;
//        res.add(root.val);
//        preorderRecursion(root.left);
//        preorderRecursion(root.right);
//    }
}
