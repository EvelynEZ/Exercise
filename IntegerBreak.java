import java.io.*;
import java.util.*;
public class IntegerBreak{
   public static void main(String[] args){
      System.out.println(integerBreak(10));
   }
   public static int integerBreak(int n) {
      if(n <= 1) 
         return 0;
      int[]f = new int[n+1];
      f[1] = 0;
      for(int i = 2; i <= n; i++){
         f[i] = f[i-1];
         for(int j = 1; j < i; j++){
            if(i >= j){
               f[i] = Math.max(j * (i-j) ,Math.max(f[i], j * f[i-j]));
            }
         }
      }
      return f[n];
   }
   
}