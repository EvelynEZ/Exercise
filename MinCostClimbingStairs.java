import java.io.*;
import java.util.*;
public class MinCostClimbingStairs{
   public static void main(String [] args){
      int[] costs = {0, 0, 0, 1};
      System.out.println(minCostClimbingStairs(costs));
   }
   
   public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n <= 2) {
            int max = 0;
            for(int c : cost){
                max = Math.max(max, c);
            }
            return max;
        }
        int[][] f = new int[n+1][2];
        f[1][1] = cost[0];
        for(int i = 2;i <= n; i++){
         f[i][0] = f[i-1][1];
         f[i][1] = Math.min(f[i-1][0], f[i-1][1]) + cost[i-1];
        }
        return Math.min(f[n][0], f[n][1]);
               
    }

}