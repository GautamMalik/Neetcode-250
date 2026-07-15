package Tree;

// ques: https://neetcode.io/problems/binary-tree-preorder-traversal/question

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if(root==null)
            return;
        ans.add(root.val);
        dfs(root.left,ans);
        dfs(root.right,ans);
    }
}
