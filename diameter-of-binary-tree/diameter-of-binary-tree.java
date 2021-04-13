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
    
 public int diameterOfBinaryTree(TreeNode root) {
        return root == null ? 0 : Math.max(height(root.left) + height(root.right), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }
    
    private int height(TreeNode root){
        return root == null? 0 : 1 + Math.max(height(root.left), height(root.right));
    }
    
}