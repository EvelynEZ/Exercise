import java.io.*;
import java.util.*;

public class countIsland{
   public static void main(String [] args) {
      char[][] grid = {{'1','1','1'},
                       {'0','1','0'},
                       {'1','1','1'}};
      System.out.println(numIslands(grid));
   }
   public static int numIslands(char[][] grid) {
      int count = 0;
      int n = grid.length;
      if (n == 0) 
         return 0;
      int m = grid[0].length;
      for (int i = 0; i < n; i++){
         for (int j = 0; j < m; j++)
            if (grid[i][j] == '1') {
               DFSMarking(grid, i, j);
               ++count;
            }
      }    
      return count;
   }

   private static void DFSMarking(char[][] grid, int i, int j) {
      if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') 
         return;
      grid[i][j] = '0';
      DFSMarking(grid, i + 1, j);
      DFSMarking(grid, i - 1, j);
      DFSMarking(grid, i, j + 1);
      DFSMarking(grid, i, j - 1);
   }
}