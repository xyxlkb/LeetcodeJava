import javax.management.QueryEval;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc102_levelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution102 so = new Solution102();
        List<List<Integer>> res = so.levelOrder(root);
        for (int i=0; i<res.size(); i++) {
            List<Integer> cur = res.get(i);
            System.out.println(cur);
//            for (int j=0; j<cur.size();j++)
//                System.out.print(cur.get(j));
//            System.out.println();
        }
    }
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> curLevel = new ArrayList<>();
        int curNum = 1;

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevel.add(cur.val); // 当前层加一个数字
            curNum--;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
            if (curNum == 0) { // 如果当前层的数字全加进去了，那么队列里剩余几个数就是下一层的数字个数
                res.add(curLevel);
                curLevel = new ArrayList<>(); // 清零
                curNum = queue.size();
            }
        }
        return res;
    }
}