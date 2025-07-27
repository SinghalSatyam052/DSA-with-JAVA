/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        int carry=0;
        while(l1 != null || l2 != null){
            int n1=0,n2=0;
            if(l1 != null) n1 = l1.val;
            if(l2 != null) n2 = l2.val;

            int sum = n1 + n2 + carry;

            if(sum>9) carry = 1;
            else carry = 0;
            res.next = new ListNode(sum%10);
            res = res.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry == 1) res.next = new ListNode(1);

        return ans.next;
    }
}