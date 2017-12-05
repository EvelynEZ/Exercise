import java.io.*;
import java.util.*;
public class NumDecodingII{
   public static void main(String[] args){
      String s = "*********";
      System.out.println(numDecodings(s));
    
   }
   //DP My solution
   public static int numDecodings(String s) {
      char[] c = s.toCharArray();
      int n = c.length;
      if(n == 0) 
         return 0;
      long[] f = new long[n + 1];
      f[0] = 1;
      for(int i = 1; i<= n; i++){
         if(c[i-1] == '*'){
            //1, 2, ..., 9
            f[i] = 9 * f[i-1];
            if(i > 1){
               if(c[i-2] == '1') f[i] += f[i-2] * 9; //11, 12, ..., 19
               if(c[i-2] == '2') f[i] += f[i-2] * 6; //21, 22, ..., 26
               if(c[i-2] == '*') f[i] += f[i-2] * 15; //11, 12, ..., 19, 21, 22, ..., 26
            } 
         } else if (c[i-1] >= '0' && c[i-1] <= '9') {
            if(c[i-1] != '0'){ //1, 2, ..., 9
               f[i] = f[i-1];
            }
            if(i > 1){
                //10, 11, ..., 19, 20, ..., 26
               if(c[i-2] == '1' || (c[i-2] == '2' && c[i-1] <= '6' && c[i-1] >= '0')) {
                  f[i] += f[i-2];
               } else if(c[i-2] == '*'){
                  if(c[i-1]<= '6' && c[i-1] >= '0'){
                     f[i] += 2 * f[i-2];
                  } else {
                     f[i] += f[i-2];
                  }
               }
            }
         }
         f[i] %= 1000000007;
      }
      return (int)f[n];
   }
}