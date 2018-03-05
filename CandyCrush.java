import java.io.*;
import java.util.*;

public class CandyCrush{
   public static void main(String [] args) {
      int[][] board = {{110,5,112,113,114},
                     {210,211,5,213,214},
                     {310,311,3,313,314},
                     {410,411,412,5,414},
                     {5,1,512,3,3},
                     {610,4,1,613,614},
                     {710,1,2,713,714},
                     {810,1,2,1,1},
                     {1,1,2,2,2},
                     {4,1,4,4,1014}};
     board = candyCrush(board);
     printBoard(board);
   }
   public static int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        if(row == 0 || col == 0) return board;
        //check board, set all crushable candies to 0.
        boolean found = true;
        while(found){
            found = false;
            for(int r = 0; r < row; r++){
                for(int c = 0; c < col; c++){
                    //check right and down side candies.
                    int curr = Math.abs(board[r][c]);
                    if(curr == 0) continue;
                    //right
                    if(c+2 < col && Math.abs(board[r][c+1]) == curr && Math.abs(board[r][c+2]) == curr){
                        found = true;
                        int right = c;
                        while(right < col && Math.abs(board[r][right]) == curr) board[r][right++] = -curr;
                    }
                    //down 
                    if(r+2 < row && Math.abs(board[r+1][c]) == curr && Math.abs(board[r+2][c]) == curr){
                        found = true;
                        int down = r;
                        while(down < row && Math.abs(board[down][c]) == curr) board[down++][c] = -curr;
                    }
                }
            }
            //check each column
            //Move candies down and chage empty  slots to 0.
            for(int c = 0 ; c < col; c++){
                int validR = row - 1;
                for(int r = row - 1; r >= 0; r--){
                    if(board[r][c] > 0) {
                        board[validR--][c] = board[r][c];   
                    }
                }
                for(; validR >= 0; validR--){
                    board[validR][c] = 0;   
                }
            }
        }
        return board;
    }
   public static void printBoard(int[][] board){
      for(int[] row : board){
         for(int n : row){
            System.out.print(n + " ");
         }
         System.out.println();
      }
      System.out.println();
   }
}