/*
1. each character in p is in s too. 
   i.e. abba -> {a:2, b:2}. 
2. Sliding window with length of s1, move from beginning to the 
end of s2. When a character moves in from right of the window, 
we subtract 1 to that character count from the map. 
When a character moves out from left of the window, 
we add 1 to that character count. So once we see all zeros in 
the map, meaning equal numbers of every characters between s1 
and the substring in the sliding window, return true.
*/
import java.io.*;
import java.util.*;
public class PermutationString{
   public static void main(String[] args) {
      String s1 = "acd";
      String s2 = "dcda";
      System.out.println(checkInclusion(s1, s2));
   }
   public static boolean checkInclusion(String s1, String s2) {
      int len1 = s1.length(), len2 = s2.length();
      if(len1 < 1 || len2 < 1|| len2 < len1) 
         return false;
      int[] count = new int[26];
      for (int i = 0; i < len1; i++) {
         count[s1.charAt(i) - 'a']++;
      }
      for(int i = 0; i <= len2 -len1; i++){
         for(int j = i; j < i+len1; j++){
            count[s2.charAt(j) - 'a']--;
         }
         if (allZero(count)) {
            return true;
         } else {
            for(int j = i; j < i+len1; j++){
               count[s2.charAt(j) - 'a']++;
            }
         }
         
      }
      return false;
   }
   
   private static boolean allZero(int[] count) {
      for (int i = 0; i < 26; i++) {
         if (count[i] != 0) 
            return false;
      }
      return true;
   }
}