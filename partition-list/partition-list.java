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
    public ListNode partition(ListNode head, int x) {
        
        if(head==null) return head;
        
        ListNode before_x = new ListNode();
        ListNode after_x = new ListNode();
        ListNode curr = head;
        ListNode first = before_x;
        ListNode second = after_x;
        
        while(curr!=null){
            
            if(curr.val< x){
                first.next = curr;
                first = first.next;
            }else{
                second.next = curr;
                second = second.next;
            }
            
            curr = curr.next;
        }
     
       
            second.next = null;
        
        first.next = after_x.next;
        
        return before_x.next;
    }
}