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
    public TreeNode increasingBST(TreeNode root) {
     if(root==null) return null;
        
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        
        TreeNode t = null;
        
        for(Integer val: res){
            t = new TreeNode(val,null, t);
        }
        return t;
        
    }
    
    private void inorder(TreeNode root, List<Integer> res){
        
        if(root==null)
            return;
        
        inorder(root.right, res);
        res.add(root.val);
        inorder(root.left, res);
        
     
        
    }
}