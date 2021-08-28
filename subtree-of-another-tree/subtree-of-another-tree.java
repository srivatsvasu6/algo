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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null && subRoot == null)
            return true;
          if(root == null || subRoot == null)
            return false;
        
        
      
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            
            for(int i = q.size(); i> 0; i--){
                
                TreeNode node = q.poll();
                
                if(isSameTree(node,subRoot)){
                    return true;
                }
                
                if(node.left!=null )
                    q.offer(node.left);
                
                if(node.right!=null)
                    q.offer(node.right);
                
                
            }
        }
        
        return false;
        
    }
    
    public boolean isSameTree(TreeNode t1, TreeNode t2){
        
        if(t1 == null && t2 == null){
            return true;
        }else    if(t1 == null || t2 == null){
            return false;
        }
        
        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}