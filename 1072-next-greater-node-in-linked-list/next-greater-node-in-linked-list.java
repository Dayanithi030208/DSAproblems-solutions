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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        head = reverseLinkedList(null, head);
        temp = head;
        while (temp != null) {
            while (!stack.isEmpty() && stack.peek() <= temp.val) {
                stack.pop();
            }
            ans[index++] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(temp.val);
            temp = temp.next;
        }
        ans = reverseArray(ans);
        return ans;
    }

    public ListNode reverseLinkedList(ListNode prev, ListNode curr) {
        if (curr == null)
            return prev;
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        return reverseLinkedList(prev, curr);
    }

    public static int[] reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
}