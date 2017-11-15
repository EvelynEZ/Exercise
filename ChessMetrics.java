import java.io.*;
import java.util.*;

public class ChessMetrics{
   public static void main(String [] args) {
      int[] start = {0, 0};
      int[] end = {0, 0};
      System.out.println(howMany(3, start, end, 2));
   }
   
   public static long howMany(int n, int[] start, int[] end, int m){
      long[][] count = new long[n][n];
      count[start[0]][start[1]] = 1;
      int[][] nextMoves = {{-1, -2}, {1, -2},
                  {-2, -1},{-1, -1}, {0, -1}, {1, -1}, {2, -1},
                  {-1, 0}, {1, 0},
                  {-2, 1}, {-1, 1}, {0, 1}, {1, 1}, {2, 1},
                  {-1, 2}, {1, 2}
                  };
      for(int iter = 0; iter < m; iter++){
         long[][] prev = count;
         count = new long[n][n];
         for(int i = 0; i < n; i++) {
            for( int j = 0; j < n; j++) {
               for(int[] nextMove:nextMoves) {
                  int x = i + nextMove[0];
                  int y = j + nextMove[1];
                  if(x >= 0 && x < n && y >= 0 && y < n) {
                     count[i + nextMove[0]][j + nextMove[1]] += prev[i][j];
                  }
               }
            }
         }
      }
      return count[end[0]][end[1]];
   }
}  

