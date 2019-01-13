/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        ListNode prev = null;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            int val = sum % 10;
            current = new ListNode(val);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            carry = sum > 9 ? 1 : 0;
            if(head == null) {
                head = current;
            }
            if(prev != null) {
                prev.next = current;
            }
            prev = current;
        }
        if(carry == 1) {
            prev.next = new ListNode(1);
        }

        return head;
    }
}
