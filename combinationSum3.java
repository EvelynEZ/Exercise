import java.io.*;
import java.util.*;

public class combinationSum3 {
   public static void main(String [] args) {
      List<List<Integer>> result = combinationSum3(3, 15);
      for(List<Integer> perm: result) {
         System.out.println(perm.toString());
      
      }
      
   }
   
   public static List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> result = new ArrayList<>();
      if(k < 1 || n < 1) 
         return result;
      List<Integer> perm = new ArrayList<>();
      helper(k, n, perm, result, 1);
      return result;
   }
    
   private static void helper(int length, int sum, List<Integer> perm, List<List<Integer>> result, int startIndex){
      if(sum < 0) 
         return;
      if(perm.size() == length){
         if(sum == 0){
            result.add(new ArrayList<Integer> (perm));
         }
         return;
      }
        
      for(int i = startIndex; i <= 9; i++){
         perm.add(i);
         helper(length, sum - i, perm, result, i+1);
         perm.remove(perm.size() - 1);
            
      }
   }

}