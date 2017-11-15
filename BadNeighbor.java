import java.io.*;
import java.util.*;

public class BadNeighbor{
   public static void main(String [] args) {
      int[] d = {};
      System.out.print(badNeighbor(d));
   }
   
   public static int badNeighbor(int[] d) {
      if(d.length == 0) return 0;
      if(d.length == 1) return d[0];
      return Math.max(getMax(Arrays.copyOfRange(d, 0, d.length - 1)), getMax(Arrays.copyOfRange(d, 1, d.length)));
   }
   
   public static int getMax(int[] a) {
      if(a.length == 0) return 0;
      if(a.length == 1) return a[0];
      int[] dp = new int[a.length];
      dp[0] = a[0];
      dp[1] = a[1];
      int max = a[0];
      for(int i = 1; i < a.length; i++) {
         for(int j = 0; j < i-1; j++) {
            dp[i] = Math.max(dp[i], dp[j] + a[i]);
         }
         max = Math.max(max, dp[i]);
      }
      return max;
   }
}