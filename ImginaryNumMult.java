import java.io.*;
import java.util.*;
public class ImginaryNumMult {
   public static void main(String[] args) {
      System.out.println(complexNumberMultiply("78+-76i","-86+72i"));
   }
  
   public static String complexNumberMultiply(String a, String b) {
      int[] A = getVal(a);
      int[] B = getVal(b);
      int x = A[0], y = A[1], u = B[0], v = B[1];
      int real = x*u - y*v;
      int imag = y*u + x*v;
      return real + "+" + imag + "i";
   }
   
   private static int[] getVal (String s) {
      int index = 0;
      String x = "" + s.charAt(index++);
      while(s.charAt(index) != '+'){
         x+=s.charAt(index++);
      }
      int xVal = Integer.parseInt(x);
      index++; // '+'
      boolean negY = false;
      if(s.charAt(index) == '-'){
         index++;
         negY = true;
      }
      String y = s.substring(index, s.length() - 1);
      int yVal = Integer.parseInt(y);
      if(negY) yVal = -yVal;
      
      int[] result = {xVal, yVal};
      return result;
   }
}