import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc94_inorderTraversal {
    public static void main(String[] args) {

    }
}

class Solution94 { // 中序遍历
    // 迭代法
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return res;

        TreeNode cur = root;
        while (!stack.empty() || cur!=null) {
            if (cur != null) {
                stack.push(cur); // 一直加入，直到最左下角
                cur = cur.left;
            }
            else {
                cur = stack.pop(); // 最新加入栈的一个就是没有左孩子的，把他加入结果
                res.add(cur.val);
                cur = cur.right; // 再看他的右孩子
            }
        }

        return res;
    }

//    递归法
//    ArrayList<Integer> res = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        inorderRecursion(root);
//        return res;
//    }
//
//    public void inorderRecursion(TreeNode root) {
//        if (root == null)
//            return;
//        inorderRecursion(root.left);
//        res.add(root.val);
//        inorderRecursion(root.right);
//    }
}
