import java.io.*;
import java.util.*;
public class AplusB{
   public static void main(String [] args){
      System.out.println(add(3, 5));
   }
   
   public static int add(int a, int b){
      while(b != 0){
         int carry = a & b;
         a = a ^ b;
         b = carry << 1;
      }
      return a;
   
   }
}