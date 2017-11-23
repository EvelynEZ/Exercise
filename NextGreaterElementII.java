import java.io.*;
import java.util.*;
public class NextGreaterElementII{
   public static void main(String[] args){
      int[] nums = {1, 2, 1};
      for(int num : nextGreaterElements(nums)){
         System.out.print(num + " ");
      }    
   }
   public static int[] nextGreaterElements(int[] nums) {
      int len = nums.length;
      int[] result = new int[len];
      Arrays.fill(result, -1);
      for(int i = 0; i < len; i++){
         int num = nums[i];
         int j = i + 1;
         while(true) {
            if(j == len) j = 0;
            if(j == i) break;
            if(nums[j] > num) {
               result[i] = nums[j];
               break;
            }
            j++;
         }
      }
      return result;
   }
}