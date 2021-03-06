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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr = head;
        int count = 0;
        
        while(count < k && curr!=null){
            curr= curr.next;
            count++;
        }
        
        
        if(count == k){
            
            ListNode revHead = reverse(head, k);
            head.next = reverseKGroup(curr, k);
            return revHead;
        }
        
        return head;
        
    }
    
    public ListNode reverse(ListNode head, int k){
        
        ListNode prev = null;
        
        ListNode curr = head;
        
        while(k > 0){
            
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        
        return prev;
    }
}