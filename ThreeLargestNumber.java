import java.io.*;
import java.util.*;
public class ThreeLargestNumber{
   public static void main(String [] args){
      //int[] nums = {1, 2, 3, 5, 6, 1, 3, 7, 2, 7, 4};
      int[] nums = {3, 2};
      System.out.println(top3(nums));
   }
   // O(n), O(n)
   /*public static List<Integer> top3 (int[] nums){
      int len = nums.length;
      List<Integer> res = new ArrayList<>();
      if(len <= 2) {
         for(int num : nums) res.add(num);
         Collections.sort(res);
         Collections.reverse(res);
         return res;
      }
      PriorityQueue<Integer> queue = new PriorityQueue<>();
      for(int num : nums){
         queue.add(num);
      }
      for(int i = 0; i < len - 3; i++) queue.poll();
      for(int i = 0; i < 3; i++){
         res.add(queue.poll());
      }
      Collections.sort(res);
      Collections.reverse(res);
      return res;
   }*/
   
   //O(n), O(1)
   public static List<Integer>  top3 (int[] nums){
      int len = nums.length;
      List<Integer> res = new ArrayList<>();
      if(len <= 2) {
         for(int num : nums) res.add(num);
         Collections.sort(res);
         Collections.reverse(res);
         return res;
      }
      int p1 = 0, p2 = 0, p3 = 0;
      for(int i = 0; i < len; i++){
         int num = nums[i];
         if(num >= nums[p1]){
            p3 = p2;
            p2 = p1;
            p1 = i;
         } else if(num >= nums[p2]){
            p3 = p2;
            p2 = i;
         } else if(num > nums[p3]){
            p3 = i;
         }
      }
      res.add(nums[p1]);
      res.add(nums[p2]);
      res.add(nums[p3]);
      return res;
   }
   
    
}