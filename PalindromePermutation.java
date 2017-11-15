/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
*/
import java.io.*;
import java.util.*;

public class PalindromePermutation {
   public static void main(String [] args) {
      String s = "code";
      System.out.println(validPalindromePerm(s));
   }
   
   public static boolean validPalindromePerm(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for(int i = 0; i < s.length(); i++) {
         char ch = s.charAt(i);
         if(map.containsKey(ch)){
            map.put(ch, map.get(ch)+1);
         } else {
            map.put(ch, 1);
         }
      
      }
      int single = 0;
      for(char c: map.keySet()){
         if(map.get(c) % 2 == 1){
            single++;
            if(single > 1) return false;
         }
      }
      return true;
   
   }

}