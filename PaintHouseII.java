/*
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?*/

//Note: what happens when k = 1;
import java.io.*;
import java.util.*;
public class PaintHouseII{
   public static void main(String[] args){
      int[][] costs = {{8, 5},
                     {1, 2}};
      System.out.println(minCostII(costs));
   }
   //Time: O(mn) Space: O(n)
   public static int minCostII(int[][] costs){
      int n = costs.length;
      if(n == 0) 
         return 0;
      int m = costs[0].length;
      if(m == 0) 
         return 0;
      if(m == 1){
         int total = 0;
         for(int i = 0; i < n; i++){
            total += costs[i][0];
         }
         return total;
      }
      int[][] f = new int[2][m];
      int old, now = 0;
      for(int i = 0; i < m; i++){
         f[now][i] = 0;
      }
      int count = 1;
          
          //house i;
      while(count <= n){
         old = now;
         now = 1 - now;
         int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
         int j1 = -1, j2 = -1;
         for(int j = 0; j < m; j++){
            if(f[old][j] < min1){
               min2 = min1;
               j2 = j1;
               min1 = f[old][j];
               j1 = j;
            } else if(f[old][j] < min2){
               min2 = f[old][j];
               j2 = j;
            }
         }
         for(int j = 0; j < m; j++){
            if(j == j1) {
               f[now][j] = min2 + costs[old][j];
            } else {
               f[now][j] = min1 + costs[old][j];
            }
         }
         count++;
      }
      int minCost = Integer.MAX_VALUE;
      for(int i = 0; i < m; i++) {
         minCost = Math.min(minCost, f[now][i]);
      } 
      return minCost; 
   }

   //Time: O(nm) Space: O(mn)
   /*public static int minCostII(int[][] costs){
        int n = costs.length;
        if(n == 0) return 0;
        int m = costs[0].length;
        if(m == 0) return 0;
        if(m == 1){
             int total = 0;
             for(int i = 0; i < n; i++){
                total += costs[i][0];
             }
             return total;
          }
          int[][] f = new int[n+1][m];
          for(int i = 0; i < m; i++){
             f[0][i] = 0;
          }
          //house i;
          for(int i = 1; i <= n; i++){
             int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
             int j1 = -1, j2 = -1;
             for(int j = 0; j < m; j++){
                 if(f[i-1][j] < min1){
                     min2 = min1;
                     j2 = j1;
                     min1 = f[i-1][j];
                     j1 = j;
                 } else if(f[i-1][j] < min2){
                     min2 = f[i-1][j];
                     j2 = j;
                 }
             }
             for(int j = 0; j < m; j++){
                 if(j == j1) {
                     f[i][j] = f[i-1][j2] + costs[i-1][j];
                 } else {
                     f[i][j] = f[i-1][j1] + costs[i-1][j];
                 }
             }
          }
          int minCost = Integer.MAX_VALUE;
          for(int i = 0; i < m; i++) {
             minCost = Math.min(minCost, f[n][i]);
          } 
          return minCost; 
       }*/
   /*
   //O(nm^2)
   public static int minCostII(int[][] costs){
      int n = costs.length;
      if(n == 0) return 0;
      int m = costs[0].length;
      if(m == 0) return 0;
      if(m == 1){
         int total = 0;
         for(int i = 0; i < n; i++){
            total += costs[i][0];
         }
         return total;
      }
      int[][] min = new int[n+1][m];
      for(int i = 0; i < m; i++){
         min[0][i] = 0;
      }
      //house i;
      for(int i = 1; i <= n; i++){
         //current house color j
         for(int j = 0; j < m; j++) {
            min[i][j] = Integer.MAX_VALUE;
            //previous house color k
            for(int k = 0; k < m; k++) {
               if(j == k) continue;
               min[i][j] = Math.min(min[i][j], min[i-1][k] + costs[i-1][j]);
            }
         }
      }
      int minCost = Integer.MAX_VALUE;
      for(int i = 0; i < m; i++) {
         minCost = Math.min(minCost, min[n][i]);
      } 
      return minCost; 
   }*/
}