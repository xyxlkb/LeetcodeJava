import java.util.ResourceBundle;

public class lc203_removeElements {
    public static void main(String[] args) {
        Solution203 so = new Solution203();
        ListNode t = new ListNode(7);
        t.next = new ListNode(8);
        t.next.next = new ListNode(7);
        ListNode res = so.removeElements(t,7);
        System.out.println(res.val);
    }
}


class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) // 如果没有元素
            return head;

        while(head!=null && head.val == val){ // 先处理开头为val的情况
            head = head.next;
        }
        if(head == null)
            return head;
        // 到这一步能保证head的值不是val
        ListNode fir = head.next;
        ListNode sec = head;
        while(fir != null) {
            if(fir.val == val) {
                fir = fir.next;
                sec.next = fir;
            }
            else {
                fir = fir.next;
                sec = sec.next;
            }
        }
        return head;
    }
}
