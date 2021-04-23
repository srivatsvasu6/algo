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
        
        
        Node dummy = new Node(0);
        Node copy = dummy;
        Node curr = head;
        Map<Node, Node> map = new HashMap<>(); 
        
        while(curr!=null){
            
            copy.next = new Node(curr.val);
            copy = copy.next;
            
            map.put(curr, copy);
            curr= curr.next;
        }
        
        copy = dummy.next;
        curr = head;
        while(curr !=null){
            
            if(curr.random!=null)
            copy.random = map.get(curr.random);
            
             copy = copy.next;
             curr= curr.next;
        }
        
        
        return dummy.next;
        
        
    }
}