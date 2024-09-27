import java.util.*;
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int data) { this.data = data; }
    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class MorrisPreorderTraversal {
    public static void morris_preorder(TreeNode root, List<Integer> list){
		TreeNode curr = root;
		while(curr != null){
			if(curr.left == null){
				list.add(curr.data);
				curr = curr.right;
			}
			else{
				TreeNode node = curr.left;
				while(node.right != null && node.right != curr){
					node = node.right;
				}
				if(node.right == null){
					node.right = curr;
					list.add(curr.data);
					curr = curr.left;
				}
				else{
					node.right = null;
					curr = curr.right;
				}
			}
		}
	}
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
		List<Integer> list = new ArrayList<>();
		morris_preorder(root, list);
		return list;
    }
}
