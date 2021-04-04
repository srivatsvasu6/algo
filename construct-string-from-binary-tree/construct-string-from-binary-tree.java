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
    public String tree2str(TreeNode t) {{
        if (t == null) return "";


        StringBuilder str = new StringBuilder();


        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.offerFirst(t);

        Set<TreeNode> set = new HashSet<>();

        while (!stk.isEmpty()) {

            TreeNode node = stk.peekFirst();

         
            if (set.contains(node)) {
                stk.pollFirst();
                str.append(")");
            } else {
                set.add(node);
                str.append("(");
                str.append( node.val);
                if (node.left == null && node.right != null) {
                    str.append("()");
                }

                if (node.right != null) {
                    stk.offerFirst(node.right);

                }
                if (node.left != null) {
                    stk.offerFirst(node.left);

                }
            }


        }
        return str.substring(1, str.length() - 1);

    }
        
    }
}