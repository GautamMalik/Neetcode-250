package Tree;

import java.util.ArrayList;
import java.util.List;

//ques: https://neetcode.io/problems/binary-tree-preorder-traversal/question
public class postOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if(root==null)
            return;
        dfs(root.left,ans);
        dfs(root.right,ans);
        ans.add(root.val);
    }
}
