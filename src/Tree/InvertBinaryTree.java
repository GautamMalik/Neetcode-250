package Tree;

// ques: https://neetcode.io/problems/invert-a-binary-tree/question?list=neetcode250

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode lst = invertTree(root.left);
        TreeNode rst = invertTree(root.right);

        root.left = rst;
        root.right = lst;
        return root;

    }
}
