/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function swapPairs(head: ListNode | null): ListNode | null {
    // base case where less than 2 elements left
    if (!head || !head.next) {
        return head;
    }
    // swap
    const temp = head.next;
    head.next = swapPairs(temp.next)
    temp.next = head;
    return temp;
};
