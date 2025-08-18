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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        int cnt = left-1;
        while(cnt-->0){
            prev = prev.next;
        }

        ListNode curr = prev.next;

        cnt = right-left;
        while(cnt-->0){
            ListNode fwd = curr.next;
            curr.next = fwd.next;
            fwd.next = prev.next;
            prev.next = fwd;
        }

        return dummy.next;

    }
}