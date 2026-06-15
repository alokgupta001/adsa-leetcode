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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode curr1 =head;
        ListNode curr2 =head;
        ListNode prev = null;
        while(curr2!=null && curr2.next!=null){
            prev = curr1;
            curr1 = curr1.next;
            curr2 = curr2.next.next;
        }
        prev.next = curr1.next;
        return head;
    }

}