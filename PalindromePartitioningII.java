import java.io.*;
import java.util.*;
public class PalindromePartitioningII{
   public static void main(String[] args){
      String s = "aab";
      System.out.println(minCut(s));
   }    
   public static int minCut(String s) {
      int n = s.length();
      if(n <= 1) return 0;
      
      boolean[][] isPalin = calcPalin(s, n);
      
      int[] f = new int[n+1];
      for(int i = 1; i <= n; i++){
         f[i] = i;
         for(int j = 0; j < i; j++){
            if(isPalin[j][i-1]){
               f[i] = Math.min(f[i], f[j] + 1);
            }
         }
      }
      return f[n]-1;
   }
    
   //isPalin[i][j] tells if s.substring(i, j-1) is palindrome
   private static boolean[][] calcPalin (String s, int n) {
      boolean[][] isPalin = new boolean[n][n];
      //for all i >= j, isPalin[i][j] = false;
      for(int i = 0; i < n; i++) {
         for(int j = i; j < n; j++){
            isPalin[i][j] = false;
         }
      }
      //odd 
      for(int mid = 0; mid < n; mid++) {
         int i = mid, j = mid;
         while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
            isPalin[i][j] = true;
            i--;
            j++;
         }
      }
      //even
      for(int mid = 0; mid < n-1; mid++){
         int i = mid, j = mid + 1;
         while( i>=0 && j <n && s.charAt(i) == s.charAt(j)) {
            isPalin[i][j] = true;
            i--;
            j++;
         }
      }
      return isPalin;
   }
}