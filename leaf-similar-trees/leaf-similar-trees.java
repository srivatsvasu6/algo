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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
     
        
    TreeNode t1  = root1, t2= root2;
   
       List<Integer> res1 = BFS(t1);
        
        System.out.println(res1);
        
       List<Integer> res2 = BFS(t2);
         System.out.println(res2);
        
       return  res1.equals(res2);
        
    }
    
    public List<Integer> BFS(TreeNode root){
        List<Integer> res = new ArrayList<>();
         Deque<TreeNode> queue = new ArrayDeque<>();
         queue.offerFirst(root);
        while(!queue.isEmpty()){
            
            TreeNode curr = queue.pollFirst();
            
            if(curr.left==null && curr.right==null){
                res.add(curr.val);
            }
            
            if(curr.left!=null){
                queue.offerFirst(curr.left);
            }
            if(curr.right!=null){
                queue.offerFirst(curr.right);
            }
            
        }
        return res;
    }
}