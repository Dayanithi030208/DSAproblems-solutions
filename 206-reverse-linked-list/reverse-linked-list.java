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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        return reversingTheList(null , head);
    }
    public ListNode reversingTheList(ListNode prev , ListNode curr){
        if(curr == null) return prev;
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        return reversingTheList(prev , curr);
    }
}
