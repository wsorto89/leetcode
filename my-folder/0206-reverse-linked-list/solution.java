/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        return recursiveReverseList(head);
    }
    
    private ListNode recursiveReverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        else {
            ListNode tail = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            
            return tail;
        }
    }
    
    private ListNode iterativeReverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        
        while(head.next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        
        return head;
    }
}
