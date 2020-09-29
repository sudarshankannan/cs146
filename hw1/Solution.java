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
    public ListNode insertionSortList(ListNode head) {
        //null case
        if(head==null || head.next==null){
            return head;
        }
        ListNode new_head = new ListNode(head.val);
        ListNode p = head.next;
        //loop through the list
        while(p!=null){
            ListNode p2 = new_head;
            ListNode nextNode = p.next;
            if(p.val <= new_head.val){
                ListNode old_head = new_head;
                new_head = p;
                new_head.next = old_head;
            }
            else{
                while(p2.next != null){
                    if(p.val > p2.val && p.val<=p2.next.val){
                        ListNode old_next = p2.next;
                        p2.next = p;
                        p.next = old_next;
                    }
                    p2 = p2.next;
                }
                if(p2.next==null && p.val > p2.val){
                    p2.next = p;
                    p.next = null;
                }
            }
            p = nextNode;
        }
        return new_head;
    }
}
