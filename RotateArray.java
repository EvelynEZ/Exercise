import java.io.*;
import java.util.*;
public class RotateArray{
   public static void main(String[] args) {
      int[] nums = {1, 2};
      rotate(nums, 3);
      for(int num : nums){
         System.out.print(num + " ");
      }
   }
   
   public static void rotate(int[] nums, int k) {
      if(k == 0 || nums.length < 2) 
         return;
      int[] result = new int[nums.length];
      for(int i = 0; i < result.length; i++){
         int index = i-k;
         while(index < 0){
            index += nums.length;
         }
         result[i] = nums[index];
      }
      for(int i =0;i < nums.length; i++) {
         nums[i] = result[i];
      }
   }
}