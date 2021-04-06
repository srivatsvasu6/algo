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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
           List<List<Integer>>  res = new ArrayList<>();
        if(root==null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        boolean rev = false;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            List<Integer> level = new ArrayList<>(); 
            int cnt = queue.size();
            for(int i=0; i< cnt; i++){

                TreeNode node = queue.poll();  
               if(!rev){
                   level.add(node.val);  
               }else{
                   level.add(0,node.val);  
               } 
                if (node.left != null) {  
                  queue.add(node.left);  
                }
                if (node.right != null) {  
                  queue.add(node.right);  
                } 
            }
            
            res.add(level);
            rev = !rev;
             
        }
        return res;
    }
}