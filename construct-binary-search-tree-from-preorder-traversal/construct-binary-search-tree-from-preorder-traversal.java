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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        if(preorder ==null || preorder.length ==0){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
     
        for(int i=1; i<preorder.length; i++){
    
        insertBST(root, preorder[i]);
            
        }
        
        return root;
        
    }
    
    public void  insertBST(TreeNode root, int val){
        
        TreeNode curr = root;
        TreeNode parent = root;
        
        while(curr!=null){
            parent = curr;
            if(val < curr.val){
                curr = curr.left;
            } else
                curr = curr.right;
            
        }
        
        
        if(curr !=null){
            
            if(curr.val < val){
                curr.right = new TreeNode(val);
            }else{
                 curr.left = new TreeNode(val);
            }
        }else{
           if(parent.val < val){
                parent.right = new TreeNode(val);
            }else{
                 parent.left = new TreeNode(val);
            } 
        }
        
    }
}