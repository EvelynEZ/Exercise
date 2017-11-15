import java.io.*;
import java.util.*;
//redundant nums

public class SingleNumber{
   public static void main(String [] args) {
      int[] nums = {2,2,3, 4, 4, 5};
      
      nums = singleNumber(nums);
      for(int num: nums) {
         System.out.println(num + " ");
      }
   }

   
   /*public static int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i=i+3){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }*/
   public static int[] singleNumber(int[] nums) {
      int[] res = new int[2];
      int index = 0;
      int i = 0;
      int len = nums.length;
      if(len == 0) 
         return res;
      Arrays.sort(nums);
      while(i < len - 1){
         if(nums[i] != nums[i+1]){
            res[index++] = nums[i++];
         } else {
            i = i + 2;
         }
      }
      if(i == len - 1){
         res[index] = nums[i];
      }
      return res;
   }
}