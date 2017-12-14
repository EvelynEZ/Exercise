import java.io.*;
import java.util.*;
public class BackPackIII{
   public static void main(String[] args){
      int[] A = {2, 3, 5, 7};
      int[] V = {1, 5, 2, 4};
      int W = 10;
      System.out.println(backpackIII(A, V, W));
   }
   /*
   //time: O(NW^2)
   public static int backpackIII(int[] A, int[] V, int w){
      int n = A.length;
      if(n == 0 ||w == 0) return 0;
      //f[i][j] = max value using i items, max weight: j
      int[][] f = new int[n+1][w+1];
      for(int i = 1; i <= n; i++){ //number of items
         for(int j = 0; j <= w; j++){ //weight 0 to w
            f[i][j] = f[i-1][j];
            for(int k = 1; k * A[i-1] <= j; k++){ //k count of A[i-1]
               f[i][j] = Math.max(f[i][j],f[i-1][j-k*A[i-1]]+k*V[i-1]); 
            }
         }
      }
      int max = 0;
      for(int j = 0; j <= w; j++){
         max = Math.max(max, f[n][j]);
      }
      return max;
   }*/
   
   //O(NW)
   public static int backpackIII(int[] A, int[] V, int w){
      int n = A.length;
      int[]f = new int[w+1];
      for(int i = 1; i <= n; i++){
         for(int j = 0; j <= w; j++){
            if(j >= A[i-1]) {
               if(f[j-A[i-1]] + V[i-1] > f[j]){
                  f[j] = f[j-A[i-1]] + V[i-1];
               }
            }
         }
      }
      return f[w];
   }

   
}