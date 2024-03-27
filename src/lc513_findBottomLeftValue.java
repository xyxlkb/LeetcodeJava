import java.util.LinkedList;
import java.util.Queue;

public class lc513_findBottomLeftValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Solution513 so = new Solution513();
        System.out.println(so.findBottomLeftValue(root));
    }
}
/*给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
假设二叉树中至少有一个节点。*/
class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        // 思路：层序遍历，每到最后一个做标记，每行第一个记录，最后一次记录的就是所求结果
        int res = 0;
        if (root == null)
            return 0;
        if (root.left==null && root.right==null)
            return root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        int curNum = 1; // 当前行节点，初始化为1，是根节点
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (flag) { // 如果flag表示这个节点是这行的第一个节点
                res = cur.val;
                flag = false;
            }
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

            curNum--;
            if (curNum == 0) {
                curNum = queue.size();
                flag = true;
            }
        }

        return res;
    }
}