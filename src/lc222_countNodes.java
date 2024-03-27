import java.util.LinkedList;
import java.util.Queue;

public class lc222_countNodes {
}

class Solution222 {
//    递归方法
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

//    层序遍历方法
//    public int countNodes(TreeNode root) {
//        int cnt = 0;
//        if (root == null)
//            return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            cnt++;
//            if (cur.left != null)
//                queue.add(cur.left);
//            if (cur.right != null)
//                queue.add(cur.right);
//        }
//        return cnt;
//    }
}