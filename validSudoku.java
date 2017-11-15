import java.io.*;
import java.util.*;
public class validSudoku {
   public static void main (String [] args) {
      char [][] board = {{'.','.','4','.','.','.','6','3','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'5','.','.','.','.','.','.','9','.'},
                        {'.','.','.','5','6','.','.','.','.'},
                        {'4','.','3','.','.','.','.','.','1'},
                        {'.','.','.','7','.','.','.','.','.'},
                        {'.','.','.','5','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'}};  
      System.out.println(isValidSudoku(board));
   
   }
   public static boolean isValidSudoku(char[][] board) {
        //valid board?
      if(board.length != 9 || board[0].length != 9) 
         return false;
        //check each row
      Set<Character> set = new HashSet<>();
      for(int row = 0; row < 9; row++){
         for(int col = 0; col < 9; col++){
            char curr = board[row][col];
            if(curr == '.'){
               continue;
            }
            /*for(int i = col+1; i < 9; i++){
               if(curr == board[row][i]) 
                  return false;
            }*/
            if(set.contains(curr)) 
               return false;
            set.add(curr);
         }
      }
        //check each column
      Set<Character> set2 = new HashSet<>();
      for (int col = 0; col < 9; col++){
         for(int row = 0; row < 9; row++){
            char curr = board[row][col];
            if(curr == '.') 
               continue;
           /* for(int i = row+1; i < 9; i++) {
               if(curr == board[i][col]){ 
                  continue;
               }
            }*/
            if(set2.contains(curr)) return false;
            set2.add(curr);
            
         }
      }
         
        //check each section
      for (int row = 0; row < 9; row++){
         for(int col = 0; col < 9; col++){
            char curr = board[row][col];
            if(curr == '.') 
               continue;
            for(int i = row - 2; i <= row + 2; i++){
               for(int j = col - 2; j <= col +2; j++){
                  if(i >= 0 && i < 9 && j >= 0 && j < 9 &&
                           row/3 == i/3 && col/3 == j/3){
                            //in same section
                     if(row != i && col != j && curr == board[i][j]) 
                        return false;
                  }
               }
            }
         }
      }
      return true;
   }


   

}