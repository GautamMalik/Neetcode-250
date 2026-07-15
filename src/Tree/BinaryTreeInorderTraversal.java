package Tree;

// ques: https://neetcode.io/problems/binary-tree-inorder-traversal/question?list=neetcode250

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if(root==null)
            return;
        dfs(root.left,ans);
        ans.add(root.val);
        dfs(root.right,ans);
    }
}
