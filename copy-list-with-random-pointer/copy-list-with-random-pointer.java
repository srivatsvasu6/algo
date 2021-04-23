/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        
     if(head == null) return head;
        
        Node curr = head;

        
        while(curr.next!=null){

            Node copy =new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
           
        }
        curr.next = new Node(curr.val);
       
        curr = head;
    
        
        while( curr!=null ){
            if(curr.random != null){
                curr.next.random=curr.random.next;
            }
            curr = curr.next.next;
        }
     
        curr = head;
        Node res = head.next;
        Node copy = head.next;
        
        while(copy.next!=null && curr.next!=null){
           
            curr.next = curr.next.next;
            copy.next = copy.next.next;
            
            curr = curr.next;
            copy = copy.next;
        }
      
       
        curr.next=null;
    
        return res;
        
        
    }
}