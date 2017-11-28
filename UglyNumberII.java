/*
The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.

Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.

Every step we choose the smallest one, and move one step after,including nums with same value.
*/
import java.io.*;
import java.util.*;
public class UglyNumberII{
   public static void main(String[] args){
      System.out.println(nthUglyNumber(4));
   }
   public static int nthUglyNumber(int n) {
      int[] ugly = new int[n];
      ugly[0] = 1;
      int fac2 = 2, fac3 = 3, fac5 = 5;
      int index2 = 0, index3 = 0, index5 = 0;
      for(int i = 1; i < n; i++) {
         int min = Math.min(Math.min(fac2, fac3), fac5);
         ugly[i] = min;
         if(fac2 == min) fac2 = 2 * ugly[++index2];
         if(fac3 == min) fac3 = 3 * ugly[++index3];
         if(fac5 == min) fac5 = 5 * ugly[++index5];      
      }
      return ugly[n-1];
   }
}