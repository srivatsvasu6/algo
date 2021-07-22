/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public static final String N = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildTree(root, sb);
        return sb.toString();
        
    }
    
    public void buildTree(TreeNode root, StringBuilder sb){
        
        if(root ==null){
            sb.append(N);
            return;
        }
        sb.append(root.val);
        sb.append(",");
        buildTree(root.left, sb);
        sb.append(",");
        buildTree(root.right, sb);
        
        
    }

    public TreeNode deser(Deque<String> data){
        
     String node =   data.remove();
        if(node.equals(N)){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(node));
        treeNode.left = deser(data);
        treeNode.right = deser(data);
        return treeNode;
    }
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        
      String[] nodes =   data.split(",");
        
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(nodes));
        
        return deser(deque);
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));