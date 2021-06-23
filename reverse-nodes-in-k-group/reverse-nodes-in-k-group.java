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
         ListNode prev = null;
        
        // Head of the final, moified linked list
        ListNode new_head = null;
         ListNode ktail = null;
        
        
        while(curr!=null){
            
        int count = 0;
            curr = head;
            
            while(count< k && curr !=null){
                
                curr = curr.next;
                count++;
            }
            
            if(count ==k){
                ListNode rev = reverse(head, k);
                
                if(new_head ==null)
                    new_head = rev;
                
                if(ktail !=null){
                    ktail.next = rev;
                }
                
                ktail = head;
                head = curr;
            }
            
        }
        
            // attach the final, possibly un-reversed portion
        if (ktail != null)
            ktail.next = head;
        
        return new_head == null ? head : new_head;
        
    }
    
    public ListNode reverse(ListNode head, int k){
         ListNode prev = null;
        ListNode curr = head;
        while(k > 0 && curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        
        return prev;
        
    }
}