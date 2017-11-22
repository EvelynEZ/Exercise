import java.io.*;
import java.util.*;
public class ThreeSumClosest{
   public static void main(String[] args) {
      int[] nums = {1, 1, 1, 1};
      System.out.println(threeSumClosest(nums, -100));
   }
   public static int threeSumClosest(int[] nums, int target) {
      if(nums.length < 3) 
         return 0;
      Arrays.sort(nums);
      int result = nums[0] + nums[1] + nums[nums.length - 1];
      for(int i = 2; i < nums.length; i++){
         int left = 0, right = i-1;
         while(left < right){
            int sum = nums[left]+nums[right]+nums[i];
            if(sum == target){
               return target;
            }else if(sum > target){
               right--;
            } else{
               left++;
            }
            if(Math.abs(sum-target) < Math.abs(result-target)){
               result = sum;
            }
         }
      }
      return result;
   }
}
