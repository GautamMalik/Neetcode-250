package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
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

      public static TreeNode getTree(){
          TreeNode treeNode = new TreeNode(4);
          treeNode.left = new TreeNode(2,new TreeNode(1),new TreeNode(3));
          treeNode.right = new TreeNode(7,new TreeNode(6),new TreeNode(9));
          return treeNode;
      }

    public static TreeNode getBSTree(){
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(2,new TreeNode(0),new TreeNode(4, new TreeNode(3),new TreeNode(5)));
        treeNode.right = new TreeNode(8,new TreeNode(7),new TreeNode(9));
        return treeNode;
    }

      public static void printTree(TreeNode node){

          Queue<TreeNode> q= new ArrayDeque<>();
          q.offer(node);

          Queue<TreeNode> cq= new ArrayDeque<>();


          while(!q.isEmpty()){

              for (TreeNode t : q) {
                  System.out.print(t.val + " ");
              }
              while(!q.isEmpty()) {
                  TreeNode temp = q.poll();
                  if (temp.left != null)
                      cq.offer(temp.left);
                  if (temp.right != null)
                      cq.offer(temp.right);
              }
              q.addAll(cq);
              cq.clear();
              System.out.println();
          }
      }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.printTree(treeNode.getTree());
    }
  }
