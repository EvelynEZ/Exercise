import java.io.*;
import java.util.*;

public class longestCommonPrefix {

   public static void main(String[] args) {
      String[] strs = new String[3];
      strs[0] = "apple";
      strs[1] = "ape";
      strs[2] = "april";
      System.out.println(longestCommonPrefix(strs));
   }
   
   public static String longestCommonPrefix(String[] strs) {
      if(strs == null) {
         return "";
      }
      String pre = "";
      String one = strs[0];
      for (int i = 0; i < one.length(); i++){
         for (String str:strs) {
            if (str.length()-1 < i || str.charAt(i) != one.charAt(i)){
               return pre;
            }
         }
         pre += one.charAt(i);
      }
      return pre;
   }
}