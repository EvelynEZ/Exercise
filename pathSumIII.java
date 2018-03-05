import java.io.*;
import java.util.*;

public class pathSumIII{
   public static void main(String [] args) {
      TreeNode root = new TreeNode(10);
      TreeNode p = root;
      p.right = new TreeNode(-3);
      TreeNode p3 = p.right;
      p3.right = new TreeNode(11);
      p.left = new TreeNode(5);
      p = p.left;
      p.left = new TreeNode(3);
      p.right = new TreeNode(2);
      TreeNode p2 = p.right;
      p2.right = new TreeNode(1);
      p = p.left;
      p.left = new TreeNode(3);
      p.right = new TreeNode(-2);
      System.out.println(pathSum(root, 8));
   }
   public static int pathSum(TreeNode root, int sum) {
      if(root == null) 
         return 0;
      return countPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
   }
   private static int countPath(TreeNode root, int sum){
      int count = 0;
      if(root == null) return 0;
      if(root.val == sum) count++;
      count += countPath(root.left, sum - root.val);
      count += countPath(root.right, sum - root.val);
      return count;
   }
   
   
}