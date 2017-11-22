/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
import java.io.*;
import java.util.*;
public class AddString{
   public static void main(String[] args) {
      String num1 = "123456789", num2 = "987654321";
      

      System.out.println(addStrings(num1, num2));
   }
   /*
   //Method 1: Potential Overflow
   public static String addStrings(String num1, String num2) {
        return convertInt(convertString(num1) + convertString(num2));
    }
    
    public static int convertString(String s){
        int index = 0;
        int num = 0;
        while(index < s.length()){
            num = num*10 + (s.charAt(index++) - '0');
        }
        return num;
    }
    
    public static String convertInt(int num){
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.insert(0, num%10);
            num = num/10;
        }
        return sb.toString();
    }*/
    //Method 2
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
    
}