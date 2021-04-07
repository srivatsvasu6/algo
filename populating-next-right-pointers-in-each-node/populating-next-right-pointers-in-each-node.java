/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
      
        if(root==null) return null;
         
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
  
        
        while(!queue.isEmpty()){
            
            int cnt = queue.size();
             Node  node = new Node();
            for(int i=0; i< cnt; i++){
                 
             
                 node.next = queue.poll();
                 node = node.next;
                
                if (node.left != null) {
                 
                  queue.add(node.left);  
                }
                if (node.right != null) {
                
                  queue.add(node.right);  
                }
                
            
            }
                         
        }
        return root; 
    }
}