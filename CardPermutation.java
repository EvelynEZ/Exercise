import java.io.*;
import java.util.*;

public class CardPermutation {

   public static void main(String [] args) {
      int a[] = {4, 3, 2, 1};
      System.out.println(solve(a));
   }
   
   public static long solve(int[] a){
      long sum = 0;
      if(a == null) return sum;
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> perm = new ArrayList<>();
      int[] nums = new int[a.length];
      for(int i = 1; i <= a.length; i++){
         nums[i-1] = i;
      }
      helper(nums, perm, result);
      for(int index = 0; index < result.size(); index++){
         if(isValid(result.get(index), a)){
            sum += index + 1;
         }
      }

      return sum;
   }

   public static void helper(int[] nums, List<Integer> perm, List<List<Integer>> result){
      if(perm.size() == nums.length) {
         result.add(new ArrayList<Integer>(perm));
         return;
      }
      for(int i = 1; i <= nums.length; i++){
         if(!perm.contains(i)){
            perm.add(i);
            helper(nums, perm, result);
            perm.remove(perm.size() - 1);
         }
      }
   }

      
   public static boolean isValid(List<Integer> perm, int[]a){
      if(perm.size() != a.length) return false;
      for(int i = 0; i < perm.size(); i++){
         if(a[i] == 0){
            continue;
         } else if (a[i] != perm.get(i)){
            return false;
         }
      }
      return true;
   
   }
}