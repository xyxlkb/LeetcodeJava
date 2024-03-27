import java.util.LinkedList;
import java.util.List;

public class lc257_binaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        Solution257 so = new Solution257();
        System.out.println(so.binaryTreePaths(root));
    }
}

class Solution257 {
    List<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return res;

        String curPath = String.valueOf(root.val); // 因为根节点前面不需要箭头，单独处理
        if (root.left==null && root.right==null)
            res.add(curPath);
        if (root.left != null)
            findPath(root.left, curPath);
        if (root.right != null)
            findPath(root.right, curPath);

        return res;
    }
    public void findPath(TreeNode root, String curPath) { // 递归
        curPath += "->";
        curPath += String.valueOf(root.val); // 先把这个点的箭头和数值加入
        if (root.left==null && root.right==null){
            res.add(curPath);
        }
        if (root.left != null)
            findPath(root.left, curPath);
        if (root.right != null)
            findPath(root.right, curPath);
    }
}