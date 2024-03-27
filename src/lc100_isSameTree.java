public class lc100_isSameTree {
}

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compareTree(p,q);
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