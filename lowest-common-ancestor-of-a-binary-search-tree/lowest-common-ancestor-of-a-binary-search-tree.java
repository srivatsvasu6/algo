/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         
        while(root!=null){
            
            int  value = root.val;
        
            if(value > p.val && value > q.val){
                System.out.println("left");
                root = root.left;
            }else if(value < p.val && value < q.val){
                root = root.right;
                 System.out.println("r");
            }else{
                 System.out.println("ams");
                return root;
            }
            
         }
        
        return null;
    }
    
}