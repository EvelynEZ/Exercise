/*
The longest Zig-Zag subsequence problem is to find length of the longest subsequence of given sequence such that all elements of this are alternating.
If a sequence {x1, x2, .. xn} is alternating sequence then its element satisfy one of the following relation :

  x1 < x2 > x3 < x4 > x5 < …. xn or 
  x1 > x2 < x3 > x4 < x5 > …. xn 
*/
import java.io.*;
import java.util.*;

public class longestZigZag{
   public static void main(String [] args) {
      int arr[] = {10, 22, 9, 33, 49, 50, 31, 60};
      System.out.println(longestZigZag(arr));
   }
   
   public static int longestZigZag(int[] a) {
      if(a.length <= 1) return a.length;
      int[][] Z = new int[a.length][2];
      //Z[i][0] length of increasing sequence.
      //Z[i][1] length of decreasing sequence.
      Z[0][0] = 1;
      Z[0][1] = 1;
      int max = 1;
      for(int i = 1; i < a.length; i++) {
         for(int j = 0; j < i; j++) {
            if(a[j] < a[i]){
               Z[i][0] = Math.max(Z[i][0], Z[j][1] + 1);
            } 
            if(a[j] > a[i]) {
               Z[i][1] = Math.max(Z[i][1], Z[j][0] + 1);
            }
         }
         max = Math.max(max, Math.max(Z[i][0], Z[i][1]));
      
      }
      return max;
   }
}