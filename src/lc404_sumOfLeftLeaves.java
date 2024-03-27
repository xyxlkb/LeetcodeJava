public class lc404_sumOfLeftLeaves {

}

class Solution404 {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        preorderRecursion(root, false);
        return sum;
    }

    // flag表示这个节点是否是某个节点的左孩子
    public void preorderRecursion(TreeNode root, boolean flag) {
        if (root.right==null && root.left==null && flag)
            sum += root.val;
        if (root.left != null)
            preorderRecursion(root.left, true);
        if (root.right != null)
            preorderRecursion(root.right, false);
    }
}
