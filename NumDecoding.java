import java.io.*;
import java.util.*;
public class NumDecoding{
   public static void main(String[] args){
      String num =  "12";
      System.out.println(numDecodings(num));
   }
   
   public static int numDecodings(String s) {
      char[] num = s.toCharArray();
      int n = num.length;
      if(n == 0) return 0;
      int[] f = new int[n + 1];
      f[0] = 1;
      for(int i = 1; i <= n; i++){
            //num[i-1] should be 1-9, no 0
         if(num[i-1] > '0' && num[i-1] <= '9') f[i] = f[i-1];
            //num[i-2]num[i-1] should be 10, 11, ...19, 20, 21, .... 26
         if(i > 1 && (num[i-2] == '1' || (num[i-2] == '2' && num[i-1] <= '6'))) f[i] += f[i-2];
      }
      return f[n];
   }
}