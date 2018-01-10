import java.io.*;
import java.util.*;
public class Decimal2Binary{
   public static void main(String [] args){
      System.out.println(binary2decimal("10"));
      System.out.println(decimal2binary(22));
   }
   
   public static int binary2decimal(String s){
      int res = 0;
      for(int i = 0; i < s.length(); i++){
        res = 2 * res + (s.charAt(i) == '0'? 0 : 1);
      }
      return res;
   }  
   
   public static String decimal2binary(int num){
      if(num == 0) return "0";
      String res = "";
      while(num > 0){
         res = "" + num % 2 + res;
         num /= 2;
      }
      return res;
   }
}
