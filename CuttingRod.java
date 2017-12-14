import java.io.*;
import java.util.*;
public class CuttingRod{
   public static void main(String[] args){
      int[] p = {3, 5, 8, 9, 10, 17, 17, 20};
      System.out.println(cutting(p, p.length));
   }
   public static int cutting(int[] prices, int n) {
      if(n == 0) return 0;
      int[] f = new int[n+1];
      int max = 0;
      for(int i = 1; i <= n; i++) {
         for(int j = 1; j <= i; j++){
            if(i >= j){
               f[i] = Math.max(f[i], prices[j-1] + f[i-j]);
            }
         }
         max = Math.max(max, f[i]);
      }
      return max;
   }
}