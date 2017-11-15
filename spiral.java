import java.io.*;
import java.util.*;

public class spiral {
   public static void main(String [] args) {
      int[][] m = {
         { 1, 2}
     
         };
      System.out.println(spiralOrder(m).toString());
   
   }
   
    public static List<Integer> spiralOrder(int[][] matrix) {
       
      List<Integer> result = new ArrayList<>();
       if(matrix.length == 0) return result;
       for(int[] item : matrix){
           if(item.length == 0) return result;
       }
      int rowEnd = matrix.length - 1; // row
      int colEnd = matrix[0].length - 1; //col
      int startRow = 0;
      int startCol = 0;

      while(startRow <= rowEnd && startCol <= colEnd){
         for(int col1 = startCol; col1 <= colEnd; col1++){
            result.add(matrix[startRow][col1]);
         }
         startRow++;
         for(int row1 = startRow; row1 <= rowEnd; row1++){
            result.add(matrix[row1][colEnd]);
         }
         colEnd--;
         for(int col2 = colEnd; col2 >= startCol && startRow <= rowEnd; col2--){
            result.add(matrix[rowEnd][col2]);
         }
         rowEnd--;
         for(int row2 = rowEnd; row2 >= startRow && startCol <= colEnd; row2-- ){
            result.add(matrix[row2][startCol]);
         }
         startCol++;
      }
      return result;
   }

}