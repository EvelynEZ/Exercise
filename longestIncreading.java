import java.util.*;
import java.io.*;

public class longestIncreasing{
   public static void main(String [] args) {
      int[] nums = {2,2};
      System.out.println(longestDecreasing(nums));
   }
   
   public static int longestIncreasing(int[] nums) {
      if(nums.length <= 1) return nums.length;
      int[] S = new int[nums.length];
      Arrays.fill(S,1);
      for(int i = 1; i < nums.length; i++) {
         for(int j = 0; j < i; j ++) {
            //increasing
            if(nums[j] < nums[i]) {
               //look for maximum length
               if(S[j] + 1 > S[i]) {
                  S[i] = S[j] + 1;
               }
            }
         }
      }
      int max = S[0];
      for(int i : S) {
         max = Math.max(max, i);
      }
      return max;
   }
}
