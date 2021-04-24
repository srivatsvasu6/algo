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
    int max = 1000000007;
    
    long maxSum = Long.MIN_VALUE;
     long total = 0;
    public int maxProduct(TreeNode root) {
    
     total = totalSum(root);
     subTreeSum(root);
        
        
      return (int)(maxSum % max);
        
    }
    
    public long subTreeSum(TreeNode root){
        if(root == null){
            return 0;
        }
        long ls = subTreeSum(root.left);
        long rs =  subTreeSum(root.right);
        long tempMax =ls + rs + root.val; 
        
        maxSum = Math.max(maxSum, (total - tempMax)  * tempMax ) ;
        System.out.println("SubTree max "+maxSum);
        
        return tempMax;
        
    }
    
      public int totalSum(TreeNode root){
        if(root ==null){
            return 0;
        }

        return root.val + totalSum(root.left) + totalSum(root.right); 
    }
    
   
}