import java.io.*;
import java.util.*;
public class Hex2Decimal{
   public static void main(String [] args){
      System.out.println(hex2decimal("1a"));
      System.out.println(decimal2hex(22));
   }
   
   public static int hex2decimal(String s){
      String digits = "0123456789abcdef";
      int res = 0;
      for(int i = 0; i < s.length(); i++){
         char c = s.charAt(i);
         int val = digits.indexOf(c);
         res = 16 * res + val;
      }
      return res;
   }  
   
   public static String decimal2hex(int num){
      String digits = "0123456789abcdef";
      if(num == 0) return "0";
      String res = "";
      while(num > 0){
         res = digits.charAt(num % 16) + res;
         num /= 16;
      }
      return res;
   }
}
