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
    private int tilt = 0;
    public int findTilt(TreeNode root) {
        
        valueSum(root);
        return tilt;
       
        
    }
    
    public int valueSum(TreeNode root){
        
        
        if(root ==null)
            return 0;
        
        int left = valueSum(root.left);
        int right = valueSum(root.right);
        
    
        
         this.tilt +=  Math.abs(left - right);
        
        
        return root.val + left + right;
    }
}