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
        Node curOriginal=head;
        
        while(curr.next!=null){
         System.out.print(curr.val+"->");
            Node copy=new Node(curr.val);
            Node temp=curr.next;
            curr.next=copy;
            copy.next=temp;
            curr=curr.next.next;
           
        }
        
        curr.next=new Node(curr.val);
       
           //step 2
    while(curOriginal!= null && curOriginal.next != null){
        if(curOriginal.random != null){
            curOriginal.next.random=curOriginal.random.next;
        }
        curOriginal=curOriginal.next.next;
    }
        
        
    Node orig=head;
    Node copyCur=head.next;
    Node copyHead=head.next;
    
    while(orig.next != null && copyCur.next != null){
        orig.next=orig.next.next;
        copyCur.next=copyCur.next.next;
        orig=orig.next;
        copyCur=copyCur.next;
    }
    orig.next=null;
    
    return copyHead;
        
        
    }
}