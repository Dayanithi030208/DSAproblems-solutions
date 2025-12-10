class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;

        while (temp1 != null || temp2 != null || carry != 0) {

            int v1 = (temp1 != null) ? temp1.val : 0;
            int v2 = (temp2 != null) ? temp2.val : 0;

            int sum = v1 + v2 + carry;

            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = node;

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }

        return dummy.next;
    }
}
