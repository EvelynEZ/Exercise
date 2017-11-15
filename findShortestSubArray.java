import java.io.*;
import java.util.*;

public class findShortestSubArray{
   public static void main(String [] args) {
      int[] nums = {1, 2, 2, 3, 1};
      System.out.println(findShortestSubArray(nums));
   }
   public static int findShortestSubArray(int[] nums) {
      int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
      Arrays.sort(temp);
      int degree = 1; //nums.degree
      int count = 1;
      List<Integer> maxOcurr = new ArrayList<>();
      for(int i = 1; i < nums.length; i++){
         if(temp[i] == temp[i-1]){
            count++;
            if(count > degree) {
               degree = count;
               maxOcurr.clear();
               maxOcurr.add(temp[i]);
            } else if(count == degree) {
               maxOcurr.add(temp[i]);
            }
         } else {
            count = 1;
         }
      }
      if(degree == 1) return 1;
      int min = nums.length;
      for(int num:maxOcurr) {
          int start = 0, end = nums.length - 1;
          for(int i = 0; i < nums.length; i++){
            if(nums[i] == num) {
               start = i;
               break;
            }
          }
          for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == num) {
               end = i;
               break;
            }
          }
         min = Math.min(min, end-start+1);
      }
      return min;
   }
}