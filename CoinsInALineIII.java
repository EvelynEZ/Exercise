//two players take coin from left or right, the one with greater value wins.(same value - first hand wins)
//determine if the first hand always wins.
import java.io.*;
import java.util.*;
public class CoinsInALineIII{
   public static void main(String[] args){
      int[] v = {1, 3, 3444, 4};
      System.out.println(firstWillWin(v));
   }
   
   public static boolean firstWillWin(int[] v){
      int n = v.length;
      if(n <= 1) return true;
      int[][] f = new int[n][n];
      for(int i = 0; i < n; i++){
         f[i][i] = v[i];
      }
      for(int len = 2; len <= n; len++){
         for(int i = 0; i <= n - len; i++){
            int j = i + len - 1;
            f[i][j] = Math.max(v[i] - f[i+1][j], v[j] - f[i][j-1]);
         }
      }
      return f[0][n-1] >= 0;
      
   }
}