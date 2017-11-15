import java.io.*;
import java.util.*;
public class IntegerToRoman{
   public static void main(String [] args) {
      int i = 3999;
      System.out.println(intToRoman(i));
   }

   public static String intToRoman(int num) {
      String[] M = {"", "M", "MM", "MMM"};
      String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
      String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
      String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
      String result = M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[(num%10)];
      return result;
        
   }
}