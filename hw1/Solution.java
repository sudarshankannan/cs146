class Solution{
    public void insertionSort(int arr[]){
        int len = arr.length;
        for(int i=1; i<n; i++){
            int curr = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j]>curr){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = curr;
        }
    }
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
        //create stack to keep track of path
        Stack<ListNode> node_stack = new Stack<ListNode>();
        node_stack.push(head);
        //another node
        ListNode rover = head;
        ListNode curr = head.next;
        //sorting done below
        //first need to (possibly) switch the first two nodes
        ListNode newHead;
        if(head.val > head.next.val){
            newHead = head;
            head.next = head;
        }
        while(curr){
            int num = curr.val;
            ListNode node = curr;
            while(node_stack.empty()!=false && node.val>num){
                node = node_stack.pop();
            }
        }
        return head;
    }
    public static void main(String[] args) {
        
    }
}