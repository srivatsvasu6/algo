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
    public TreeNode invertTree(TreeNode root) {
        
        invert(root);
        
        return root;
        
    }
    
    public void invert(TreeNode root){
        TreeNode curr = root;
        
        if(curr==null){
            return;
        }

          TreeNode left = curr.left;
          TreeNode right = curr.right;
          TreeNode temp = null; 
       
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
    

        invert(curr.left);
        invert(curr.right);
    }
}