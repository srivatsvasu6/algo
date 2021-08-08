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
    int max = 0;
    public int goodNodes(TreeNode root) {
        
       return helper(root, -10000);
    }
    
    public int helper(TreeNode root, int min){
        
        if(root == null)
            return 0;
        int cnt = 0; 
       
        cnt += (root.val >= min)? 1: 0;
        
        cnt += helper(root.left, Math.max(root.val, min));
        cnt += helper(root.right, Math.max(root.val, min));
        
        return cnt;
    }
}