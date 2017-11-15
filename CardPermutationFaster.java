import java.io.*;
import java.util.*;

public class CardPermutationFaster {
   static int index = 1;
   static long sum = 0;
   public static void main(String [] args) {
      int a[] = {0, 2, 3, 0 };
      System.out.println(solve(a));
   }
   
   public static long solve(int[] a){
      if(a == null) return sum;
      //List<List<Integer>> result = new ArrayList<>();
      List<Integer> perm = new ArrayList<>();
      List<Integer> result = new ArrayList<>();
      int[] nums = new int[a.length];
      for(int i = 1; i <= a.length; i++){
         nums[i-1] = i;
      }
      helper(a, nums, perm, result);
      /*for(int num:result){
         sum += num;
      }*/

      return sum;
   }

   public static void helper(int[] a, int[] nums, List<Integer> perm, List<Integer> result){
      if(isValid(perm, a)) {
         result.add(index);
         sum += index;
         return;
      }
      for(int i = 1; i <= nums.length; i++){
         if(!perm.contains(i)){
            perm.add(i);
            helper(a, nums, perm, result);
            if(perm.size() == a.length) index++;
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