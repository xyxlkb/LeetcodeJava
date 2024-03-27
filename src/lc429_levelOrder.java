//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//};
//
//public class lc429_levelOrder {
//    public static void main(String[] args) {
//
//    }
//}
//
//class Solution429 {
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> res = new LinkedList<>();
//        if (root == null)
//            return res;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        int curNum = 1;
//        List<Integer> curLevel = new LinkedList<>();
//        while (!queue.isEmpty()) {
//            Node cur = queue.poll();
//            curLevel.add(cur.val);
//            for (Node node : cur.children) // 把这个节点所有孩子加入
//                queue.add(node);
//            curNum--;
//            if (curNum == 0) {
//                res.add(curLevel);
//                curLevel = new LinkedList<>();
//                curNum = queue.size();
//            }
//        }
//        return res;
//    }
//}
