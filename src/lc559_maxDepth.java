import java.util.List;

public class lc559_maxDepth {
}
/*给定一个 N 叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution559 {
    // 可以用层序遍历，但是写过太多次了，用回溯试试
    int res;
    public void getDepth(Node root, int depth) {
        if (depth > res) // 回溯的过程中看看是否取得更大的值，更新
            res = depth;
        for (Node cur : root.children) { // 遍历所有孩子
            depth++;
            getDepth(cur, depth);
            depth--;
        }
    }

    public int maxDepth(Node root) {
        res = 0;
        if (root == null)
            return res;
        getDepth(root, 1);
        return res;
    }
}
