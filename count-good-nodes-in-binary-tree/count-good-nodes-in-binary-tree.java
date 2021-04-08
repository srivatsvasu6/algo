/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class Pair{
        
        TreeNode node;
        int max;
        Pair(){
            
        }
        Pair(TreeNode node,int max){
            this.node = node;
            this.max = max;
        }
        
    }
    public int goodNodes(TreeNode root) {
        int count = 0;
        
        TreeNode curr = root;
        
        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,root.val));
        
        while(!queue.isEmpty()){
            
            Pair p = queue.poll();
            TreeNode node = p.node;
            int max = p.max;
            if(node.val>= max){
                max = node.val;
                count++;
                
            }
            if(node.left!=null)
                queue.offer(new Pair(node.left, max));
             if(node.right!=null)
               queue.offer(new Pair(node.right, max));
        
        }
       
        
        return count;
    }
}