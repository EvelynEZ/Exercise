import java.io.*;
import java.util.*;
public class Division{
   public static void main(String [] args){
      System.out.println(divide(-13, 3));
   }
   
   //dividend / divisor
   public static int divide(int dividend, int divisor){
      //overflow
      if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
         return Integer.MAX_VALUE;      
      }
      //sign
      int sign = (dividend ^ divisor) >> 31;
      //positive division
      //use long to avoid overflow
      int res = helper(Math.abs(Long.valueOf(dividend)), Math.abs(Long.valueOf(divisor)));
      return sign == 0? res : -res;
   }
   
   public static int helper(long top, long bottom){
      if(top < bottom) return 0;
      int count = 1;
      long curr = bottom;
      while(curr <= (top>>2)){
         curr <<= 1;
         count <<= 1;
      }
      count += helper(top - curr, bottom);
      return count;
   }
   
   
}