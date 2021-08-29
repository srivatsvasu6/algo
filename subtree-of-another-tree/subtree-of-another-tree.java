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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return t == null;
    	return isSame(s, t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
	
    private boolean isSame(TreeNode s, TreeNode t){
    	if(s==null || t == null) return t == s;
    	return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}