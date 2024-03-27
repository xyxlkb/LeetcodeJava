import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.LinkedList;
import java.util.Queue;

public class lc111_minDepth {
}

class Solution111 {
    public int minDepth(TreeNode root) {
        int mindepth = 0;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left==null && cur.right==null) // 到最小的叶子节点了
                return mindepth+1;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

            curNum--;
            if (curNum == 0) {
                mindepth++;
                curNum = queue.size();
            }
        }
        return mindepth;
    }
}