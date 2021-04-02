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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return  isUnivalTree(root.val, root);
        
        
    }
     public boolean isUnivalTree(int val, TreeNode root) {
        
        if(root == null){
            return true;
        }
       
        return  (root.val ==val ) && isUnivalTree(val, root.left) &&
                    isUnivalTree(val, root.right);
        
        
    }
}