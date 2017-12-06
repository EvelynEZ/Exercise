//Note that for test reasons, sort the array before looking for the subsets
import java.io.*;
import java.util.*;
public class SubsetII{
   public static void main(String[] args){
      int[]nums = {1,2,2};
      List<List<Integer>> res = subsetsWithDup(nums);
      for(List<Integer> sub : res){
         System.out.println(sub.toString());
      }
   }
    
   public static List<List<Integer>> subsetsWithDup(int[] nums) {
      Set<List<Integer>> res = new HashSet<>();
      List<Integer> sub = new ArrayList<>();
      Arrays.sort(nums);
      helper(nums, 0, sub, res);
      List<List<Integer>> r = new ArrayList<>();
      for(List<Integer> l : res){
         r.add(l);
      }
      return r;
   }
    
   private static void helper(int[] nums, int index, List<Integer> sub, Set<List<Integer>> res){
      res.add(new ArrayList<Integer>(sub));
      for(int i = index; i < nums.length; i++){
         sub.add(nums[i]);
         helper(nums, i+1, sub, res);
         sub.remove(sub.size()-1);
      }
   }
}