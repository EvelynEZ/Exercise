import java.io.*;
import java.util.*;
public class minSubArrayLen{
   public static void main(String[] args) {
      int[] nums = {1, 2};
      System.out.println(minSubArrayLen(11,nums));
   }
   public static int minSubArrayLen(int s, int[] nums) {
      int len = nums.length;
      if(len < 1) return 0;
      int min = Integer.MAX_VALUE;
      boolean found = false;
      for(int i = 0; i < len; i++) {
         int sum = 0;
         for(int j = i; j < len; j++){
            sum+=nums[j];
            if(sum >= s) {
               min = Math.min(min, j - i + 1);
               found = true;
               break;
            }
         }
      }
      return found?min:0;
   }
}