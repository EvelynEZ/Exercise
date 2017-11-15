import java.io.*;
import java.util.*;

public class nextPermutation{
   public static void main(String [] args) {
      int[] nums = {1, 1, 5};
      nextPermutation(nums);
      for(int n:nums){
         System.out.print(n + " ");
      }
   }
   
   public static void nextPermutation(int[] nums) {
      int k = -1;
      for(int i = nums.length - 2; i >= 0; i--) {
         if(nums[i] < nums[i+1]){
            k = i;
            break;
         }  
      }
      //this permutation is the last.
      if(k == -1){
         for(int start = 0, end = nums.length - 1; start < end; start++, end--){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
         }
         return;
      }
      int l = -1;
      for(int i = nums.length - 1; i >= 0; i--) {
         if(nums[i] > nums[k]){
            l = i;
            break;
         }
      }
      //swap k and l.
      int temp = nums[k];
      nums[k] = nums[l];
      nums[l] = temp;
      //reverse all numbers after k
      int front = k+1, end = nums.length - 1;
      while(front < end) {
         int t = nums[front];
         nums[front] = nums[end];
         nums[end] = t;
         front++;
         end--;
      }
      
   }
   /*
    //Time Limit Exceeded
    public static  void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        for(int num : nums) {
            n.add(num);
        }
        Arrays.sort(nums);
        int[] visited = new int[nums.length];

        helper(nums, perm, result, visited);
        int index = result.indexOf(n) + 1;
        if(index == 0) return; //no such permutation.
        if(index >= result.size()){
            index = 0;
        }
        List<Integer> r = result.get(index);
        for(int i = 0; i < r.size(); i++){
            nums[i] = r.get(i);
        }
    }
    
  public static void helper(int[] nums, List<Integer> perm, List<List<Integer>> result, int[] visited) {
      if (perm.size() == nums.length) {
         result.add(new ArrayList<Integer>(perm));
         return;
      }
      for(int i = 0; i < nums.length; i++){
         if(i != 0 && nums[i] == nums[i-1] && visited[i-1] == 1) continue;
         if(visited[i] == 1) continue;
         perm.add(nums[i]);
         visited[i] = 1;
         helper(nums, perm, result ,visited);
         perm.remove(perm.size() - 1);
         visited[i] = 0;
      }
   
   }*/
}