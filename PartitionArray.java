/*Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.
*/
import java.io.*;
import java.util.*;
public class PartitionArray {
   public static void main(String [] args) {
      int[] a = {6,6,8,6,7,9,8,7,9,6,8,6,8,9,8,7,8,6,7,6,6,8,6,6};
      System.out.println(partitionArray(a, 5));
   }
   public static int partitionArray(int[] nums, int k) {
        if(nums.length < 1){
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while(left < right){
            while(left < right && nums[left] < k) left++;
            while(left < right && nums[right] >= k) right--;
            if(left < right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }
        if(nums[left] >= k){
            return left;
        } else {
            return left+1;
        }
    }
}