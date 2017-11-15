public class StringfromBT {
   public static void main(String [] args) {
      TreeNode tree = new TreeNode(1);
      tree.left = new TreeNode(2);
      tree.left.right = new TreeNode(4);
      tree.right = new TreeNode(3);
      System.out.println(tree2str(tree));
   
   }
   public static String tree2str(TreeNode t) {
      if(t == null) return"";
      if(t.left == null && t.right == null) {
         return "" + t.val;
      }
      if(t.left == null) return t.val + "()(" + tree2str(t.right) + ")";
      if(t.right == null) return t.val + "(" +tree2str(t.left) + ")";
      return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
   }
}