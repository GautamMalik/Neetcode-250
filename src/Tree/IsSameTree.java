package Tree;

// ques: https://neetcode.io/problems/same-binary-tree/question?list=neetcode250

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p == null && q != null) || (p != null && q == null) || p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);

    }
}
