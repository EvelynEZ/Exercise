import java.io.*;
import java.util.*;
public class JumpGameII{
   public static void main(String[] args){
      int[] nums = {0, 1};
      System.out.println(jump(nums));
   }
   
   public static int jump(int[] nums){
      int max = 0;
      
   
   }
   /*
   //Time Limit Exceed
   public static int jump(int[] nums) {
      int[] step = new int[nums.length];
      for(int index = 0; index < nums.length; index++){
         int len = nums[index];
         if(len == 0) 
            continue;
         for(int i = index - len; i <= index + len; i++){
            if(i<0 || i >=nums.length) 
               continue;
            if(step[i] != 0) 
               continue;
            if(i == index) 
               continue;
            step[i] = step[index] + 1;
            if(i == nums.length - 1) 
               return step[i];
         }
      }
      return step[nums.length - 1];
   }*/
}