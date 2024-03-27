public class lc19_removeNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution19 so = new Solution19();
        printLinkedList(so.removeNthFromEnd(head,2));

    }

    static void printLinkedList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode dummyNode = new ListNode(0); // 虚拟头节点，这样走起来方便，不用单独处理head
        dummyNode.next = head;
        ListNode fastNode = dummyNode;
        ListNode slowNode = dummyNode;


        for(int i=0;i<n;i++)
            fastNode = fastNode.next;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

//        System.out.println(slowNode.val);
//        System.out.println(fastNode.val);
        slowNode.next = slowNode.next.next;

        return dummyNode.next;
    }
}
