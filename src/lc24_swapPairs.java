import javax.security.auth.login.CredentialNotFoundException;
import java.awt.*;

public class lc24_swapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution24 so = new Solution24();
        so.swapPairs(head);
//        printLinkedList(head);

    }

    static void printLinkedList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) // 如果长度为0或1
            return head;

        ListNode curNode = head;
        ListNode nexNode = head.next;
        curNode.next = nexNode.next; // 第一个节点单独处理，因为头节点没有前面一个
        nexNode.next = curNode;
        head = nexNode;

        ListNode preNode = curNode;
        while(curNode != null){
            curNode = preNode.next;
            if(curNode == null)
                break;
            nexNode = curNode.next;
            if(nexNode == null)
                break;
            preNode.next = nexNode;
            curNode.next = nexNode.next;
            nexNode.next = curNode;

            preNode = curNode;
        }
        return head;
    }
}
