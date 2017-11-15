import java.io.*;
import java.util.*;


public class permutation{
   public static void main(String [] args) {
      int[] nums = {1, 3, 2};
      System.out.println(permute(nums).toString());
   
   }

   public static List<List<Integer>> permute(int[] nums){
      List<List<Integer>> result = new ArrayList<>();
      if(nums == null) return result;
      if(nums.length == 0){
         result.add(new ArrayList<Integer>());
         return result;
      }
      List<Integer> perm = new ArrayList<>();
      helper(nums, perm, result);
      return result;
   }
   
   public static void helper(int[] nums, List<Integer> perm, List<List<Integer>> result) {
      if (perm.size() == nums.length) {
         result.add(new ArrayList<Integer>(perm));
         return;
      }
      for(int i = 0; i < nums.length; i++){
         if(!perm.contains(nums[i])){
            perm.add(nums[i]);
            helper(nums, perm, result);
            perm.remove(perm.size() - 1);
         }      
      }
   
   }
}