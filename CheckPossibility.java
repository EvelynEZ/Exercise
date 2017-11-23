/*
 Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 
 We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 */
import java.io.*;
import java.util.*;
public class checkPossibility {
   public static void main(String[] args) {
      int[] nums = {3, 4, 2, 3};
      System.out.println(checkPossibility(nums));
   }
   
   public static boolean checkPossibility(int[] nums) {
      if (nums.length < 1) 
         return true;
      int count = 0;
      for(int i = 1; i < nums.length; i++){
         if(nums[i] < nums[i-1]){
            count++;
            if(i-2 >= 0 && nums[i] < nums[i-2]){
               nums[i] = nums[i-1];
            } else {
               nums[i-1] = nums[i];
            }
            if(count > 1) 
               return false;
         }
      }
      return true;
   }
   
   /* 
   //without modifying the int[].
   public static boolean checkPossibility(int[] a) {
        int modified = 0;
        for (int i = 1, prev = a[0]; i < a.length; i++) {
            if (a[i] < prev) {
                if (modified++ > 0) return false;
                if (i - 2 >= 0 && a[i - 2] > a[i]) continue;
            }
            prev = a[i];
        }
        return true;
    }
   
   */
}
