import java.io.*;
import java.util.*;
public class AtoI{
   public static void main(String [] args) {
      System.out.println(myAtoi("+-"));
   }
   public static int myAtoi(String str) {
        //chekc empty string
      if(str.length() == 0) 
         return 0;
        //sign = 1, positive number. 
      int index = 0, sign  = 1, total = 0;
        //omit whitespace at beginning
      while(str.charAt(index) == ' ' && index < str.length()){
         index++;
      }
        //get sign
      if((str.charAt(index) == '+' || str.charAt(index) == '-') ){
         sign = str.charAt(index) == '+'? 1:-1;
         index++;
      }
      while(index < str.length()){
         int digit = str.charAt(index) - '0';
         if(digit < 0 || digit > 9) 
            break; // not number
            //check for overflow
         if(Integer.MAX_VALUE/10 < total || (Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 <digit)){
            total = Integer.MAX_VALUE;
            break;
         }
         total = total*10 + digit;
         index++;
      }
      return sign * total;
   }
}