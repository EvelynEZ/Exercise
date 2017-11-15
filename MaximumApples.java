import java.io.*;
import java.util.*;

public class MaximumApples{
   public static void main(String [] args) {
      int[][] apples = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}};
      System.out.println(maxApples(apples));
   }
   
   public static int maxApples(int[][] apples){
      int row = apples.length;
      int col = apples[0].length;
      int[][] dp = new int[row][col];
      dp[0][0] = apples[0][0];
      for(int i = 0; i < row; i++) {
         for(int j = 0; j < col; j++) {
            if(i == 0 && j == 0) continue;
            int upper = dp[i > 0?i - 1:0][j];
            int left = dp[i][j > 0?j - 1:0];
            dp[i][j] = Math.max(upper, left) + apples[i][j];
         }
      }
      return dp[row-1][col-1];
   }
}