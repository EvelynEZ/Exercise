import java.io.*;
import java.util.*;
public class RussianDollEnvelope{
   public static void main(String[] args){
      int[][] env = {{5,4},{6,4},{6,7},{2,3}};
      System.out.println(maxEnvelopes(env));
   }
   //O(n^2)
   public static int maxEnvelopes(int[][] envelopes) {
      //Sort by area
      Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0]*a[1], b[0]*b[1])); //O(nlogn)
      int len = envelopes.length;
      int[] dp = new int[len];
      Arrays.fill(dp, 1);
      int max = 1;
      for(int i = 1; i < len; i++) {
         for(int j = 0; j < i; j++) { //O(n^2)
            if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
               dp[i] = Math.max(dp[i], dp[j] + 1);
            }
         }
         if(dp[i] > max) max = dp[i];
      }
      return max;
   }
   
}