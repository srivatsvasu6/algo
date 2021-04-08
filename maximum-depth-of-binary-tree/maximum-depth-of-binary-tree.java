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
    public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
      Stack<TreeNode> stack = new Stack<>();
      Stack<Integer> depth = new Stack<>();
        depth.push(1);
        stack.push(root);
        int max =1;
        while(!stack.isEmpty()){
            
            TreeNode node = stack.pop();
            int level = depth.pop();
            
            max = Math.max(max, level);
            
            if(node.right!=null){
                stack.push(node.right);
                depth.push(level+1);
            }
             
            if(node.left!=null){
                stack.push(node.left);
                depth.push(level+1);
            }
        }
        
        return max;
        
        
    }
}