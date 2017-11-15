import java.io.*;
import java.util.*;
public class ExcelColTitle {
   public static void main(String[] args) {
      System.out.println(convertToTitle(28));
   }
   
   public static String convertToTitle(int n) {
      StringBuilder sb = new StringBuilder();
      while(n > 0) {
         n--;
         sb.insert(0, (char)('A' + n%26));
         n /= 26;
      }
      return sb.toString();
   }

}