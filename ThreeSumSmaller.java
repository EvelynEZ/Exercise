/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]

*/

import java.io.*;
import java.util.*;
public class ThreeSumSmaller{
   public static void main(String[] args) {
      int[] a = {-2, 0, 1, 3};
      System.out.println(threeSumSmaller(a, 2));
   }
   
   public static int threeSumSmaller(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            int left = 0, right = i-1;
            while(left < right) {
                if(nums[left] + nums[right] < target - nums[i]){
                    cnt += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return cnt;
    }
}