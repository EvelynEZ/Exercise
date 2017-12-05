import java.io.*;
import java.util.*;
public class LongestIncreasingSubsequencePrint{
   public static void main(String[] args){
      int[] nums = {4, 2, 4, 5, 3, 7};
      System.out.println("Length: " + longestIncreasingSubsequence(nums));
   }
   public static int longestIncreasingSubsequence(int[] nums) {
         int n = nums.length;
         if( n <= 1) return n;
         int[] f = new int[n];
         int[] prev = new int[n];
         int besti = 1;
         Arrays.fill(f, 1);
         Arrays.fill(prev, -1);
         int max = 1;
         for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && f[j] + 1 > f[i]){
                    f[i] = f[j] + 1;
                    prev[i] = j;
                }
            }
            if(f[i] > max) {
               max = f[i];
               besti = i;
            }
         }
         int[] seq = new int[max];
         int j = besti;
         for(int i = max-1; i>= 0; i--) {
            seq[i] = nums[j];
            j = prev[j];
            System.out.print(seq[i] + " ");
         }
         return max;
    }
}