import java.io.*;
import java.util.*;
public class MergeString{
   public static void main(String [] args) {
      int i;
      do{
         i++;
      }
      while (i < 0);
      System.out.println(mergeStrings("abc", "scad"));
   }

   public static String mergeStrings(String a, String b) {
      StringBuilder builder = new StringBuilder();
      int j = 0;
      for (int i=0; i < a.length(); i++) {
         builder.append(a.charAt(i));
         if (j < b.length()) {
            builder.append(b.charAt(j));  
            j++;
         }
      }
   // if str2 has more chars than str
      if (j < b.length()) {
      // append ALL chars starting from index j
         builder.append(b.substring(j));
      }
      return builder.toString();
   }
}