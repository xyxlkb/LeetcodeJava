import java.awt.*;
import java.util.spi.CurrencyNameProvider;

public class lc112_hasPathSum {
}
/*给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
如果存在，返回 true ；否则，返回 false 。
叶子节点 是指没有子节点的节点。*/
class Solution112 {
    boolean flag;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        flag = false;
        recursion(root, 0, targetSum);

        return flag;
    }

    public void recursion(TreeNode root, int curSum, int targetSum) {
        if (flag) // 如果已经找到了，就不用继续找了，节省时间
            return;

        curSum += root.val;
        if (root.left==null && root.right==null) {
            if (curSum == targetSum)
                flag = true;
        }
        if (root.left != null)
            recursion(root.left, curSum, targetSum);
        if (root.right != null)
            recursion(root.right, curSum, targetSum);
    }
}
