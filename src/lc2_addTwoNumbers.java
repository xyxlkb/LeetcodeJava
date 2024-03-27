public class lc2_addTwoNumbers {
    public static void main(String[] args) {
        Solution2 test = new Solution2();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode res = test.addTwoNumbers(l1,l2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}

/**
 * Definition for singly-linked list. */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // add all numbers to listnode1 no matter l1 or l2 is longer
        ListNode ln1 = l1; // record result to return
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry; // add carry from last digit
            carry = sum / 10; // carry for next digit
            l1.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null && l2==null){
            if(carry != 0){
                ListNode newnode = new ListNode(carry);
                l1 = ln1;
                while(l1.next != null)
                    l1 = l1.next;
                l1.next = newnode;
                return ln1;
            }
        }
        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum % 10;
            l1.val = sum / 10;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode newnode = new ListNode();
            l1.next = newnode;
            l1 = newnode;
            l1.val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }
        return ln1;
    }
}
