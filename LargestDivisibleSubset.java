import java.io.*;
import java.util.*;
public class LargestDivisibleSubset{
   public static void main(String[] args){
      int[] nums = {1, 2, 3};
      List<Integer> result = largestDivisibleSubset(nums);
      for(int i : result){
         System.out.print(i + " ");
      }
   }
   public static List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        if(len == 0) return result;
        Arrays.sort(nums);
        int[] pre = new int[len];
        int[] count = new int[len];
        Arrays.fill(count, 1);
        Arrays.fill(pre, -1);
        int maxIndex = 0;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && count[i] < count[j] + 1){
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            if(count[i] > count[maxIndex]){
                maxIndex = i;
            }
        }
        
        while(maxIndex != -1){
            result.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        Collections.reverse(result);
        return result;
    }
}