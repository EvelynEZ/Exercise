import java.io.*;
import java.util.*;
public class GenerateParenthesis{
   public static void main(String [] args) {
      System.out.println(generateParenthesis(3).toString());
   }
   public static List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();
      if(n < 1) 
         return result;
      StringBuilder sb = new StringBuilder();
      helper(sb, result, 0, 0, n);
      return result;
   }
   
   private static void helper(StringBuilder sb, List<String> result, int open, int close, int n) {
      if(sb.length() == n * 2){
         result.add(sb.toString());
         return;
      }
      if(open < n) {
         sb.append("(");
         helper(sb, result, open+1, close, n);
         sb.deleteCharAt(sb.length() - 1);
      }
      if(close < open) {
         sb.append(")");
         helper(sb, result, open, close+1, n);
         sb.deleteCharAt(sb.length() - 1);
      }
   
   }
}