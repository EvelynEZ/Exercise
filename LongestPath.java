import java.io.*;
import java.util.*;
public class LongestPath{
   public static int max = 0;

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      TreeNode p = root;
      p.left = new TreeNode(1);
     
      System.out.println(longestUnivaluePath(root));
   }
    public static int longestUnivaluePath(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        helper(root);
        return max;
    }
    
    public static int helper(TreeNode root){
        int lengthL = 0;
        if(root.left != null){
            lengthL = helper(root.left);
            if(root.val == root.left.val) {
               lengthL++;
            }     
        }
        int lengthR = 0;
        if(root.right != null) {
            lengthR = helper(root.right);
            if(root.val == root.right.val) {
               lengthR++;
            }
        }
        max = Math.max(max, lengthL + lengthR);
        return Math.max(lengthL, lengthR);
    }
   
}