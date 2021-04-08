/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.StringJoiner;
public class Codec {

    public void serializeBST(TreeNode root, StringJoiner str) {
     if(root ==null){
         str.add("x");
         return;
     }
     str.add(root.val+"");
     serializeBST(root.left, str);
     serializeBST(root.right, str);
     
         
 }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner str = new StringJoiner(",");
        serializeBST(root, str);
        return str.toString();
        
    }
 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        return deserialize(Arrays.stream(data.split(",")).iterator());
        
        
    }
    
    public TreeNode  deserialize(Iterator<String> iterator) {
     
        String val = iterator.next();
        
        if(val.equals("x")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(iterator);
        node.right = deserialize(iterator);
        return node;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;