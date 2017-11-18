import java.io.*;
import java.util.*;
public class SortColors{
   public static void main(String[] args) {
      int[] nums = {1, 1};
      sortColors(nums);
      for(int n : nums){
         System.out.println(n +" ");
      }
   }
   
   public static void sortColors(int[] nums) {
      if(nums.length <= 1) 
         return;
        //Sort red to front
      int front = 0, other = 0;
      while(nums[front] == 0){
         front = front+1;
         other = other+1;
         if(front >= nums.length) return;
      }
      front = switchPos(nums, front, other, 0);
        //sort white to front
      other = front;
      while(nums[front] == 1){
         front++;
         other++;
         if(front >= nums.length) return;
      }
      front = switchPos(nums, front, other, 1);
   }
    
   public static int switchPos(int[] nums, int front, int other, int color){
      while(other<nums.length){
         if(nums[other] == color){ 
            int tmp = nums[front];
            nums[front++] = color;
            nums[other++] = tmp;
         } else {
            other++;
         }
      } 
      return front; 
   }
}