//import java.util.LinkedList;
//import java.util.Queue;
//
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//};
//public class lc116_connect {
//}
//
//class Solution116 {
//    public Node connect(Node root) {
//        if (root == null)
//            return root;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        int curNum = 1;
//        Node preNode = null; // 记录前一个节点
//        while (!queue.isEmpty()) {
//            Node curNode = queue.poll();
//            if (preNode != null)
//                preNode.next = curNode;
//            preNode = curNode;
//
//            if (curNode.left != null)
//                queue.add(curNode.left);
//            if (curNode.right != null)
//                queue.add(curNode.right);
//
//            curNum--;
//            if (curNum == 0) {
//                preNode = null;
//                curNum = queue.size();
//            }
//        }
//
//        return root;
//    }
//}