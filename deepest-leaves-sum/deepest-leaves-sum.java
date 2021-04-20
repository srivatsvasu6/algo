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
    public int deepestLeavesSum(TreeNode root) {
    
        if(root ==null)
            return 0;
        int depth = depthOfTree(root);
        
        return deepestSum(root, depth);
    }
    
    public int deepestSum(TreeNode root , int depth){
        
        if(root==null){
            return 0;
        }
        
        if(depth == 1){
            return root.val;
        }
        
        return deepestSum(root.left, depth -1)  + deepestSum(root.right, depth -1);
    }
    
    public int depthOfTree(TreeNode root){
         if(root ==null)
            return 0;
        
        return 1+ Math.max(depthOfTree(root.left), depthOfTree(root.right));
    }
}