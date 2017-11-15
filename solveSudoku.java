import java.io.*;
import java.util.*;
public class solveSudoku {
   public static void main (String [] args) {
      char [][] board = {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}}; 
      solveSudoku(board); 
      boolean valid = true;
      for(char[] row:board){
         if(!valid) break;
         for(char ch:row) {
            if(ch == '.') {
               System.out.println("No Valid Solution");
               valid = false;
               break;
            }
         }
      }
      for(int i = 0; i < 9; i++) {
         for(int j = 0; j <  9; j++) {
            
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
   }
   
   public static void solveSudoku(char[][] board) {
      if(board == null || board.length == 0 || board[0].length == 0) 
         return;
      helper(board);
   }
    
   private static boolean helper(char[][] board){
      for(int row = 0; row < 9; row++){
         for(int col = 0; col < 9; col++){
            if(board[row][col] != '.') 
               continue;
            for(char c = '1'; c <= '9'; c++){
               if(isValid(row, col, board, c)){
                  board[row][col] = c;
                  if(helper(board)){
                     return true;
                  } else {
                     board[row][col] = '.';
                  }
               }
            }
            return false;
         }
      }
      return true;
   }
   private static boolean isValid(int row, int col, char[][] board, char c){
      //check row and col
      for(int i = 0; i < 9; i++) {
         if(board[row][i] == c) 
            return false;
         if(board[i][col] == c) 
            return false;
      }      
   
      for(int i = row - 2; i <= row + 2; i++){
         if (i < 0 || i > 8 ) 
            continue;
         for(int j = col - 2; j <= col + 2; j++){
            if(j < 0 || j > 8) 
               continue;
            if(row/3 == i/3 && col/3 == j/3){ //same section
               if(board[i][j] == c) 
                  return false;
            }
         }
      }
      return true;
   }
}