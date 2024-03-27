public class lc206_reverseList {
}

class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode();
        while(head != null){
            ListNode curNode = head; // 记录下来用
            head = head.next;
            curNode.next = res.next;
            res.next = curNode;
        }
        return res.next;
    }
}
