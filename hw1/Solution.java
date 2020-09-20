class Solution{
    public ListNode insertionSortList(ListNode head) {
        //null head case
        if(head == null){
            return head;
        }
        //one node case
        if(head.next == null){
            return head;
        }
        //two node case
        if(head.next.next!=null){
            if(head.val > head.next.val){
                return head.next;
            }
            else{
                return head;
            }
        }
        //sorting done below
        //first need to (possibly) switch the first two nodes
        ListNode newHead = null;
        ListNode curr = head;
        ListNode nxt;
        while(curr!=null){
            nxt = curr.next;
            newHead = insert(newHead,curr,head);
            curr = nxt;
        }
        return newHead;
    }
    ListNode insert(ListNode newHead, ListNode newNode, ListNode head){
        if(newHead == null || head.val >= newNode.val){
            newNode.next = newHead;
            return newNode;
        }
        else{
            ListNode curr = newHead;
            while(curr.next!=null && curr.next.val<newNode.val){
                curr = curr.next;
                newNode.next = curr.next;
                curr.next = newNode;
            }
        }
        return newHead;
    }
    public static void main(String[] args) {
        
    }
}