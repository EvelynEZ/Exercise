import java.io.*;
import java.util.*;
public class MineSweeper{
   public static void main(String [] args){
      char[][] board = {{'E', 'E', 'E', 'E', 'E'},
         {'E', 'E', 'M', 'E', 'E'},
         {'E', 'E', 'E', 'E', 'E'},
         {'E', 'E', 'E', 'E', 'E'}};
      int[] click = {3, 0};
      board = updateBoard(board, click);
      for(char [] cs : board){
         for(char c : cs){
            System.out.print(c + " ");
         }
         System.out.println();
      
      }
   }
   public static char[][] updateBoard(char[][] board, int[] click){
      int m = board.length;
      int n = board[0].length;
      int row = click[0];
      int col = click[1];
      
      if(board[row][col] == 'M'){
         board[row][col] = 'X';
      } else {
         int count = 0;
         for(int i = -1; i <= 1; i++){
            for(int j = -1; j<= 1; j++){
               int r = row + i;
               int c = col + j;
               if(r < 0 || r >=m || c < 0 || c >= n) continue;
               if(board[r][c] == 'M' || board[r][c] == 'X') count++;
            }
         }
         if(count > 0){
            board[row][col] = (char)(count + '0');
         } else {
            board[row][col] = 'B';
            for(int i = -1; i <= 1; i++){
               for(int j = -1; j <= 1; j++){
                  if(i == 0 && j == 0) continue;
                  int r = row + i;
                  int c = col + j;
                  if(r < 0 || r >=m || c < 0 || c >= n) continue;
                 
                  if(board[r][c] == 'E') {
                     int[] newClick = {r, c};
                     updateBoard(board, newClick);
                  }
               
               }
            
            }
         }
      
      }
      
      return board; 
   }
}