import java.io.*;
import java.util.*;

public class pathSum{
   public static void main(String [] args) {
      TreeNode root = new TreeNode(-2);
      TreeNode p = root;
      p.right = new TreeNode(-3);
      /*p.left = new TreeNode(4);
      p = p.left;
      p.left = new TreeNode(11);
      p = p.left;
      p.left = new TreeNode(7);
      p.right = new TreeNode(2);
      p = root;
      p.right = new TreeNode(8);
      p = p.right;
      p.left = new TreeNode(13);
      p.right = new TreeNode(4); 
      p = p.right;
      p.left = new TreeNode(5);
      p.right = new TreeNode(1);*/
      List<List<Integer>> path = pathSum(root, -5);
      System.out.println(path.toString());
   }
   public static List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> combination = new ArrayList<>();
      if(root == null){
         res.add(combination);
         return res;
      }
      helper(root, sum, res, combination);
      return res;
   }
   public static void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> combination){
      if(root == null) 
         return;
      combination.add(root.val);

      if(root.val == sum && root.left == null && root.right == null){
         res.add(new ArrayList<Integer>(combination));
         combination.remove(combination.size() - 1);
         return;
      } 
      helper(root.left, sum - root.val, res, combination);
      helper(root.right, sum - root.val, res, combination);
      combination.remove(combination.size() - 1);
        
   }
   
   
}