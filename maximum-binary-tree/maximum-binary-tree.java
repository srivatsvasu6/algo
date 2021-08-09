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
    
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      
         if(nums.length ==0){
           return null;
        }
        
        TreeNode node = new TreeNode();    
        if(nums.length ==1){
            node.val = nums[0];
            return node;
        }
        

        int a=Integer.MIN_VALUE, maxIndex = 0;
        
        for(int i = 0; i<nums.length; i++){
            
            if(a < nums[i]){
                a = nums[i];
                maxIndex= i;
            }
        }
        
        node.val = a;
        
        if(maxIndex!=0)
        node.left =  constructMaximumBinaryTree(Arrays.copyOfRange(nums,0, maxIndex));

        node.right =  constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIndex+1, nums.length));
        
        return node;
    }
}