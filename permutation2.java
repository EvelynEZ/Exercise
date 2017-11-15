import java.io.*;
import java.util.*;
//redundant nums

public class permutation2{
   public static void main(String [] args) {
      int[] nums = {3, 3, 0, 3};
      System.out.println(permute2(nums).toString());
   
   }

   public static List<List<Integer>> permute2(int[] nums){
      List<List<Integer>> result = new ArrayList<>();
      if(nums == null) 
         return result;
      if(nums.length == 0){
         result.add(new ArrayList<Integer>());
         return result;
      }
      List<Integer> perm = new ArrayList<>();
      int[] visited = new int[nums.length];
      Arrays.sort(nums);
      helper(nums, perm, result, visited);
      return result;
   }
   
   public static void helper(int[] nums, List<Integer> perm, List<List<Integer>> result, int[] visited) {
      if (perm.size() == nums.length) {
         result.add(new ArrayList<Integer>(perm));
         return;
      }
      for(int i = 0; i < nums.length; i++){
         if(i != 0 && nums[i] == nums[i-1] && visited[i-1] == 1) continue;
         if(visited[i] == 1) continue;
         perm.add(nums[i]);
         visited[i] = 1;
         helper(nums, perm, result ,visited);
         perm.remove(perm.size() - 1);
         visited[i] = 0;
      }
   
   }
}