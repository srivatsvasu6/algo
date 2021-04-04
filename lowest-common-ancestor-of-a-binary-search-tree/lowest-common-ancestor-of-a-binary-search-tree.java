/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
        int pval = p.val;
        
        int qval = q.val;
        
        TreeNode node = root;
        
        while(node!=null){
            
            int parent = node.val;
            
            if(pval> parent && qval> parent){
                node = node.right;
            }else if(pval<parent && qval< parent){
                node = node.left;
            }else{
                return node;
            }
        }

        return null;
 
    }
    
  
    
   
}