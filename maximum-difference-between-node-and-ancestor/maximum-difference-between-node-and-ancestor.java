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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root, Integer.MAX_VALUE,Integer.MIN_VALUE );
        return ans;
    }
    
     public int dfs(TreeNode root, int min, int max){
        if(root == null){
            return 0;
        }

        max = Math.max(max, root.val);
        min  = Math.min(min, root.val);

        ans = Math.max(ans, Math.abs(max - min));

        dfs(root.left, min, max);
        dfs(root.right, min, max);

        return ans;
    }
}