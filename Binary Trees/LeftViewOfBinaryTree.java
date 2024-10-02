import java.util.*;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class LeftViewOfBinaryTree
{
    void findLeftView(Node node, int level, ArrayList<Integer> ans)
    {
        if(node == null) return ;
        if(level == ans.size())
        {
            ans.add(node.data);
        }
        findLeftView(node.left, level+1, ans);
        findLeftView(node.right, level+1, ans);
        //change the above recursion to go right and then left for right view
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans = new ArrayList<>();
      findLeftView(root, 0, ans);
      return ans;
    }
}

//Level order Iterative Traversal takes O(N) space complexity, that's why we used recursive traversal that takes O(H) space complexity
// TC : O(N)