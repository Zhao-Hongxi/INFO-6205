class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        while(p!=null){
            ListNode n = p;
            for(int i = 0; i < k && n != null ; i++){
                n = n.next;
                if( n == null)
                    return dummy.next;
            }
            ListNode pre = new ListNode(), next = new ListNode();
            ListNode cur = p.next;
            for(int i = 0; i < k; i++){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode newH = p.next;
            newH.next = cur;
            p.next = pre;
            p = newH;
        }
        return dummy.next;
    }
}