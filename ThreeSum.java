
import java.io.*;
import java.util.*;
public class ThreeSum{
   public static void main(String[] args) {
      int[] S = {0,0,0,0};
      List<List<Integer>> result = threeSum(S);
      for(List<Integer> l : result) {
         System.out.println(l.toString());
      }
   }
   
   public static List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if(nums.length < 1) 
         return result;
      Arrays.sort(nums);
      for(int i = 0; i < nums.length - 2; i++) {
         if(i > 0 && nums[i] == nums[i-1]) 
            continue;
         int target = -nums[i];
         int left = i + 1;
         int right = nums.length - 1;
         TwoSum(result, nums, left, right, target);
      }
      return result;
   }
    
   public static void TwoSum(List<List<Integer>> result, 
            int[] nums, int left, int right, int target){
      Set<Integer> set = new HashSet<>();
      for(int i = left; i <= right; i++){
         List<Integer> list = new ArrayList<>();
         list.add(-target);
         if(set.contains(target - nums[i])){
            list.add(target - nums[i]);
            list.add(nums[i]);
            result.add(list);
         } else {
            set.add(nums[i]);
         }
      }
      /*while(left < right) {
         if(nums[left] + nums[right] == target) {
            List<Integer> list = new ArrayList<>();
            list.add(-target);
            list.add(nums[left]);
            list.add(nums[right]);
            result.add(list);
            left++;
            right--;
            while(left < right && nums[left] == nums[left-1]) {
               left++;
            }
            while(left < right && nums[right] == nums[right+1]) {
               right--;
            }
         } else if(nums[left] + nums[right] > target) {
            right--;
         } else {
            left++;
         }
      }*/
   }
}