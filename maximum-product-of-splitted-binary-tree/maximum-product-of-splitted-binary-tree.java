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
 
    
    public int maxProduct(TreeNode root) {
    

         subTreeSum(root);
        
        
      return (int)(maxSum % max);
        
    }
    
    public long subTreeSum(TreeNode root){
        if(root == null){
            return 0;
        }
     
        
         Map<TreeNode, Long> memo = new HashMap<>();
           long  total = totalSum(root, memo);
        Deque<TreeNode> deq = new LinkedList<>();
        deq.push(root);
              
      
        while(!deq.isEmpty()){
            
            TreeNode node = deq.pop();
               
            long sum = node.val;
                if(node.left!=null){
                    sum+= totalSum(node.left, memo);
                    deq.push(node.left);
                }
        
                if(node.right!=null){
                    sum+= totalSum(node.right, memo);
                    deq.push(node.right);
                }
             
              maxSum = Math.max(maxSum, (total - sum)  * sum ) ;
        }
        
        
      
        
        return maxSum;
        
    }
    
      public long totalSum(TreeNode root, Map<TreeNode, Long> memo){
        if(root ==null){
            return 0;
        }
        
      if(memo.containsKey(root)){
         return memo.get(root);
      }

        long res = root.val + totalSum(root.left, memo) + totalSum(root.right, memo); 
          
         memo.put( root, res);
         return res; 
    }
    
   
}