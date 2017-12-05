import java.io.*;
import java.util.*;
public class PaintHouse{
   public static void main(String[] args){
      int[][]cost = {{1, 2, 3},
                     {2, 3, 4},
                     {3, 4, 5}};
      System.out.println(minCost(cost));
   }
   public static int minCost(int[][] costs) {
      int n = costs.length;
      if(n == 0 || costs[0].length == 0) return 0;
      int[][] min = new int[n+1][3];
      min[0][0] = min[0][1] = min[0][2] = 0;
      //current house: i, current color: j
      for(int i = 1; i <= n; i++){
         for(int j = 0; j <=2 ;j++) {
            if(j == 0){
               min[i][j] = Math.min(min[i-1][1],min[i-1][2]);
            }
            if(j == 1){
               min[i][j] = Math.min(min[i-1][0],min[i-1][2]);
            }
            if(j == 2){
               min[i][j] = Math.min(min[i-1][0],min[i-1][1]);
            }
            min[i][j] += costs[i-1][j];
         }
      }
      return Math.min(Math.min(min[n][0], min[n][1]), min[n][2]);
   }
}