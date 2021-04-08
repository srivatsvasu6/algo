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
    public boolean isValidBST(TreeNode root) {
        
        if(root ==null){
            return true;
        }
        
        Deque<TreeNode> stk = new LinkedList<>();
        int val = root.val;
 
        TreeNode pre = null;
        TreeNode node = root;
        while(!stk.isEmpty()|| node!=null){
            
            while(node!=null){
                stk.offerFirst(node);
                node = node.left;
            }
            
            node = stk.pollFirst();
            
            if(pre != null && node.val <= pre.val) 
                return false;
            
            pre = node;
            node = node.right;
            
            
        }
        return true;
        
    }
}