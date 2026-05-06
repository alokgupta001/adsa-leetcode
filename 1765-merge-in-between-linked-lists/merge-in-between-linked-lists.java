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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ans = list1;
        ListNode curr = list1;
        for(int i=0;i<a-1;i++){
            curr = curr.next;
        }
        ListNode p1 = curr;
        for(int i=a-1;i<=b;i++){
            curr = curr.next;
        }
        p1.next = list2;
        while(p1.next!=null){
            p1=p1.next;
        }
        p1.next = curr;
        return list1;
    }
}