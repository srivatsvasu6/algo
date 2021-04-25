class Solution {
    long max = 0;
    int half = 0;
    public int maxProduct(TreeNode root) {
        add(root);
        half = root.val / 2;
        compute(root, root.val);
        return (int) (max % (1e9 + 7));
    }
    
    public int add(TreeNode root){
        if (root == null) return 0;
        root.val += add(root.left) + add(root.right);
        return root.val;
    }
    
    public void compute(TreeNode node, long sum){
        if (node == null) return;
        max = Math.max(max, (node.val * (sum - node.val)));
        if (node.val >= half){
             compute(node.left, sum);
             compute(node.right, sum);
        }
       
    }
   
}