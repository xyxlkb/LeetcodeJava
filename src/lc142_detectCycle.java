public class lc142_detectCycle {
    public static void main(String[] args) {

    }
}

class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null)
                return null;
            fast = fast.next;
            if (fast == null)
                return null; // fast走两步，碰到null说明没环，返回null
            slow = slow.next; // slow走一步
            if (slow.equals(fast)) { // 相碰了说明有环
                while (!fast.equals(head)) { // fast和head同时出发，相遇的节点是环的入口节点
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}


