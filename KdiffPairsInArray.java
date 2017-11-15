import java.io.*;
import java.util.*;

public class KdiffPairsInArray{
   public static void main(String [] args) {
      int[] nums = {1,3,1,5,4};
      int k = 0;
      System.out.println(findPairs(nums, k));
   }
   
   public static int findPairs(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k < 0)   
         return 0;
      Map<Integer, Integer> map = new HashMap<>();
      for(int num : nums){
         map.put(num, map.getOrDefault(num, 0) + 1);
      }
      int count = 0;
      for(Integer key : map.keySet()){
         if(k == 0 && map.get(key) > 1){
            count++;
         } else if(k != 0 && map.containsKey(key + k)){
            count++;
           
         }
      }
      return count;
        
   }
}