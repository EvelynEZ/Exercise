import java.io.*;
import java.util.*;
public class PivotIndex{
   public static void main(String[] args){
      int[] array = {1, 7, 3, 6, 5, 6};
      System.out.println(pivotIndex(array));
   }
   
   public static int pivotIndex(int[] nums) {
      if(nums.length < 3)return -1;
      int total = 0;
      for(int i : nums) {
         total += i;
      }
      int left = 0;
      for(int i = 0; i < nums.length; i++){
         int right = total - left - nums[i];
         if(left == right) return i;
         left += nums[i];
      }
      return -1;
   }
}