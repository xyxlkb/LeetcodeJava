import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc637_averageOfLevels {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution637 so = new Solution637();
        List<Double> res = so.averageOfLevels(root);
        System.out.println(res);
    }
}

class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();


        queue.add(root);
        int curNum = 1; // 记录这一层有几个数字
        double curSum = 0.0; // 记录这一层的和
        int curNumRecord = curNum;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curSum += cur.val;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
            curNum--;
            if (curNum == 0) {
                res.add(curSum/curNumRecord);
                curNum = queue.size();
                curNumRecord = curNum;
                curSum = 0.0;
            }
        }

        return res;
    }
}