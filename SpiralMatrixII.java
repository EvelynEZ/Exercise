import java.io.*;
import java.util.*;
public class SpiralMatrixII{
   public static void main(String[] args){
      int[][] matrix = generateMatrix(4);
      for(int[] m : matrix){
         for(int n : m){
            System.out.print(n + " ");
         }
         System.out.println();
      }
   }
   public static int[][] generateMatrix(int n) {
      int[][] res = new int[n][n];
      if(n == 0) 
         return res;
      int startRow = 0, endRow = n-1, startCol = 0, endCol = n-1;
      int num = 1;
      while(num <= Math.pow(n, 2)){
         for(int i = startCol; i<= endCol && startCol<= endCol; i++){
            res[startRow][i] = num++;
         }
         startRow++;
         for(int i = startRow; i<= endRow && startRow<=endRow; i++){
            res[i][endCol] = num++;
         }
         endCol--;
         for(int i = endCol; i>=startCol && startCol <= endCol; i--){
            res[endRow][i] = num++;
         }
         endRow--;
         for(int i = endRow; i>=startRow && startRow <= endRow; i--){
            res[i][startCol] = num++;
         }
         startCol++;
      }
      return res;
   }   
}