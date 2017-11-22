import java.io.*;
import java.util.*;
public class SortColors{
   public static void main(String[] args) {
      int[] nums = {1, 0, 2, 1};
      sortColors(nums);
      for(int n : nums){
         System.out.println(n +" ");
      }
   }
   
   //Method 2
   public static void sortColors(int[] nums) {
      if(nums.length < 1) return;
      int left = 0, right = nums.length - 1, i = 0;
      while(i <= right) {
         if(nums[i] == 0) {
            swap(nums, i, left);
            left++;
            i++;
         } else if(nums[i] == 1) {
            i++;
         } else {
            swap(nums, i, right);
            right--;
         }
      }
   }
   
   public static void swap(int[]nums, int i, int p) {
      int tmp = nums[p];
      nums[p] = nums[i];
      nums[i] = tmp;
   }
   
   /*
   //Method 1
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
   }*/
}