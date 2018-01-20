import java.io.*;
import java.util.*;
public class WiggleSort{
   public static void main(String [] args){
      int[] nums = {3, 5, 2, 1, 6, 4};
      wiggleSort(nums);
      System.out.println(Arrays.toString(nums));
   }
   
   public static void wiggleSort(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(i % 2 == 1 && nums[i-1] > nums[i]) {
                swap(nums, i);
            } else if(i % 2 == 0 && i != 0 && nums[i-1] < nums[i]) {
                swap(nums, i);
            }
        }
    }
    
    private static void swap (int[] nums, int i){
        int temp = nums[i-1];
        nums[i-1] = nums[i];
        nums[i] = temp;
    }
}