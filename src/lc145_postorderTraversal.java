import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class lc145_postorderTraversal {
    public static void main(String[] args) {
        Solution145 so = new Solution145();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(so.postorderTraversal(root));
    }
}

class Solution145 {
    // 迭代法
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return res;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null)
                stack.add(cur.left);
            if (cur.right != null)
                stack.add(cur.right);
        }
        Collections.reverse(res);

        return res;
    }

//    递归法
//    ArrayList<Integer> res = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        postorderRecursion(root);
//        return res;
//    }
//
//    public void postorderRecursion(TreeNode root) {
//        if (root == null)
//            return;
//        postorderRecursion(root.left);
//        postorderRecursion(root.right);
//        res.add(root.val);
//    }
}