import java.util.*;

public class lc107_levelOrderBottom {
}

class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
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
        Collections.reverse(res); // 反转LinkedList
        return res;
    }
}
