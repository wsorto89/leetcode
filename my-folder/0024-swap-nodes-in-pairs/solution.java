/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        if(cur == null) {
            return cur;
        }
        ListNode swap = head.next;
        if(swap == null) {
            return cur;
        }
        
        cur.next = swapPairs(swap.next);
        swap.next = cur;
        return swap;
        /*ListNode prev = null;
        head = swap;
        
        while(cur.next != null && swap.next != null) {
            cur.next = swap.next;
            swap.next = cur;
            if(prev != null) {
                prev.next = swap;
            }
            prev = cur;
            cur = cur.next;
            swap = cur.next;
        }
        if(swap != null) {
            cur.next = swap.next;
            swap.next = cur;
            if(prev != null) {
                prev.next = swap;
            }
        }
        
        return head;*/
    }
}
