import java.io.*;
import java.util.*;

public class isValidBST{
   public static void main(String [] args) {
      TreeNode root = new TreeNode(10);
      TreeNode p = root;
      p.left = new TreeNode(5);
      p.right = new TreeNode(15);
      p = p.right;
      p.left = new TreeNode(6);
      p.right = new TreeNode(20);
      System.out.println(isValidBST(root));
   }
   public static boolean isValidBST(TreeNode root) {
      if(root == null) 
         return true;
      return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }
    
   public static boolean helper (TreeNode root, int min, int max){
      if (root == null) 
         return true;
      if(root.val >= max || root.val <= min) 
         return false;
      return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        
   }   
   
}