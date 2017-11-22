
import java.io.*;
import java.util.*;
public class PartitionByOddandEven{
   public static void main(String[] args) {
      int[] nums = {2147483644,2147483645,2147483646,2147483647};
      partitionArray(nums);
      for(int num:nums)
      System.out.println(num);
   }
   public static void partitionArray(int[] nums) {
        if(nums.length < 1) return;
        int left = 0, right = nums.length - 1;
        while(left < right){
            while(left < right && nums[left] % 2 == 1) left++;
            while(left < right && nums[right] % 2 == 0) right--;
            if(left < right){
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }
    }
}