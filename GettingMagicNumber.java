import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GettingMagicNumber {

   static int getMagicNumber(String s, int k, int b, int m){
      int total = 0;
      int[] power = new int[10];
      for (int j = 0; j < 10; j++) {
         power[j] =(int) Math.pow(b, j);
      }  
      for (int i = 0; i <= s.length() - k; i++){
         String sub = s.substring(i, i+k);
         int converted = 0;
         if (Integer.parseInt(sub) != 0){
            for (int bit = 0 ; bit < k; bit++){
               int num = Integer.parseInt(sub.substring(k-1-bit, k-bit));
               converted += num * power[bit];
            } 
            total += converted%m;
         }
      }
      
      return total;
   }


   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String s = in.next();
      int k = in.nextInt();
      int b = in.nextInt();
      int m = in.nextInt();
      int result = getMagicNumber(s, k, b, m);
      System.out.println(result);
   }
}
