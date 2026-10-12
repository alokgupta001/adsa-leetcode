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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l:lists){
            if(l!=null)pq.offer(l);
        };
        ListNode head = new ListNode();
        ListNode ans  = head;
        while(!pq.isEmpty()){
            head.next = pq.poll();
            if(head.next.next!=null) pq.offer(head.next.next);
            head = head.next;
        }
        return ans.next;
    }
}