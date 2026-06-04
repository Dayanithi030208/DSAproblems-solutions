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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode temp = head;
        while(temp != null && temp.val == val){
            temp = temp.next;
        }
        if(temp == null) return temp;
        head = temp;
        while(temp != null){
            ListNode trv = temp;
            while(trv.next != null && trv.next.val == val){
                trv.next = trv.next.next;
            }
            temp = trv.next;
        }
        return head;
    }
}