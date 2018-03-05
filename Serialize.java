import java.io.*;
import java.util.*;

public class Serialize{
   public static void main(String [] args) {
      TreeNode head = new TreeNode(1);
      head.left = new TreeNode(2);
      head.right = new TreeNode(3);
      TreeNode p = head.right;
      p.left = new TreeNode(4);
      p.right = new TreeNode(5);
      System.out.println(serialize(head));
      TreeNode node = deserialize(serialize(head));
      
   }
   // Encodes a tree to a single string.
   public static String serialize(TreeNode root) {
      String res = "";
      if(root == null) 
         return "x ";
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      while(!q.isEmpty()){
         TreeNode node = q.poll();
         if(node == null) {
            res += "x ";
            continue;
         }
         res += node.val + " ";
         q.offer(node.left);
         q.offer(node.right);
      }
      return res;
   }

    // Decodes your encoded data to tree.
   public static TreeNode deserialize(String data) {
      String[] vals = data.split(" ");
      if(vals.length == 1) 
         return null;
      Queue<TreeNode> q = new LinkedList<>();        
      TreeNode head = new TreeNode(Integer.valueOf(vals[0]));
      q.offer(head);
      int i = 1;
      while(!q.isEmpty()){
         TreeNode node = q.poll();
         if(!vals[i].equals("x")){
            TreeNode left = new TreeNode(Integer.valueOf(vals[i]));
            q.offer(left);
            node.left = left;
         }
         i++;
         if(!vals[i].equals("x")){
            TreeNode right = new TreeNode(Integer.valueOf(vals[i]));
            q.offer(right);
            node.right = right;
         }
         i++;
      }
      return head;
   }
}