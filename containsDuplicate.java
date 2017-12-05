import java.io.*;
import java.util.*;

public class containsDuplicate{
   public static void main(String [] args) {
      int[] nums = {-1,2147483647};
      System.out.println(containsNearbyAlmostDuplicate(nums,1, 2147483647));
   }
   //Not AC
   public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      if(nums.length == 0 || k <= 0) 
         return false;
      int index = 0;
      TreeSet<Integer> set = new TreeSet<>();
      for(int i = 0; i < nums.length; i++){
         if(set.ceiling(nums[i])!= null){
            if(set.ceiling(nums[i]) - nums[i] <= t) 
               return true;
         }
         if(set.floor(nums[i])!=null) {
            if(nums[i] - set.floor(nums[i]) <= t) 
               return true;
         }
         if(set.size() == k) 
            set.remove(nums[index++]);
         set.add(nums[i]);
      }
      return false;
   }
   /*
   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int p = 0; 
        if(nums.length==0) return false; 
        if(k==0) return false; 

        TreeSet<Long> set = new TreeSet<>(); 
        for(int i = 0; i<nums.length; i++){
            Long tmp1 = set.ceiling((long)nums[i]);
            Long tmp2 = set.floor((long)nums[i]); 
            if(tmp1!=null && tmp1 - nums[i]<=t) return true; 
            if(tmp2!=null && nums[i] - tmp2<=t) return true; 
            
            if(set.size()==k) set.remove((long)nums[p++]); 
            set.add((long)nums[i]); 
        }
        return false; 
    }  */
   
}