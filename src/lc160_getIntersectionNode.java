public class lc160_getIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode com = new ListNode(3);
        headA.next = com;
        headB.next = com;
        Solution160 so = new Solution160();
        System.out.println(so.getIntersectionNode(headA,headB).val);

    }
}

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curNode = headA;
        while (curNode != null) {
            curNode = curNode.next;
            lenA++;
        }
        curNode = headB;
        while (curNode != null) {
            curNode = curNode.next;
            lenB++;
        }

        if(lenB > lenA) {
            for (int i=0; i<lenB-lenA; i++)
                headB = headB.next;
        }
        else {
            for (int i=0; i<lenA-lenB; i++)
                headA = headA.next;
        }

        while(!headA.equals(headB)) {
            headA = headA.next;
            headB = headB.next;
            if (headB==null)
                return null;
        }
        return headA;
    }
}
