//Given an integer array of size n, find all elements that appear more 
//than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
import java.io.*;
import java.util.*;
//Boyer Moore Majority Algorithm
public class MajorityElementsII{
   public static void main(String [] args) {
      int[] nums = {1, 3, 2, 3, 1, 3, 1, 2};
      for(int i : majorityElement(nums)){
         System.out.print(i);
      }
   }
   public static List<Integer> majorityElement(int[] nums) {
      List<Integer> res = new ArrayList<>();
      if(nums.length <= 2) {
         for(int n : nums) {
            if(res.contains(n)) continue;
            res.add(n);
         }
         return res;
      }
      
      int candidate1 = nums[0], candidate2 = nums[1];
      int count1 = 0, count2 = 0;
      for(int n : nums){
         if(n == candidate1){
            count1++;
         } else if (n == candidate2) {
            count2++;
         } else if (count1 == 0){
            candidate1 = n;
            count1 = 1;
         } else if (count2 == 0){
            candidate2 = n;
            count2 = 1;
         } else {
            count1--;
            count2--;
         }
      }
      count1 = 0;
      count2 = 0;
      for(int num : nums){
         if(num == candidate1){
            count1++;
         } else if(num == candidate2) {
            count2++;
         }
      }
      if(count1 >= nums.length / 3) res.add(candidate1);
      if(count2 >= nums.length / 3) res.add(candidate2);
      return res;
   }

}