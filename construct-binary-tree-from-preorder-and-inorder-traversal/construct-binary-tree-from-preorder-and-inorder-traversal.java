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
    int preIndex=0;
    Map<Integer,Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        return arrToTree(preorder, 0,preorder.length-1 );
    }
     public TreeNode arrToTree(int[] preorder, int left, int right){
         
         if(left > right)
             return null;
         
         int rootVal = preorder[preIndex++];
         
         TreeNode root = new TreeNode(rootVal);
         
         root.left =  arrToTree(preorder, left , inorderMap.get(rootVal)-1 );
         
         root.right = arrToTree(preorder,  inorderMap.get(rootVal)+1, right );
         
         return root;
         
     }
    
}