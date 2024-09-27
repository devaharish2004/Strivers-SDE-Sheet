import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
public class MorrisInorderTraversal {
    public void morris_inorder(TreeNode root, List<Integer> list){
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }
            //left subtree not null
            else{
                //find the rightmost node of the left subtree
                TreeNode node = curr.left;
                //move as right as possible
                while(node.right != null && node.right != curr){
                    node = node.right;
                }
                //check if the thread is not present
                if(node.right == null){
                    //create the thread
                    node.right = curr;
                    curr = curr.left;
                }   
                else{
                    //remove the already created thread
                    node.right = null;
                    //add the curr node to inorder as left tree is already traversed
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        morris_inorder(root, list);
        return list;
    }
}