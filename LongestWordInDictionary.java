/*
Note: Lexicographically different:
Given two different sequences of the same length, 
a1a2...ak and b1b2...bk, the first one is smaller than the second one for the lexicographical
 order, if ai<bi (for the order of A), for the first i where ai and bi differ.
 
720. Longest Word in Dictionary
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.

Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
*/

import java.io.*;
import java.util.*;
public class LongestWordInDictionary{
   public static void main(String [] args){
      String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
      System.out.println(longestWord(words));
   }
   //slower?
   public static String longestWord(String[] words) {
      if(words.length == 0) 
         return "";
      Set<String> set = new HashSet<>();
      for(String s: words){
         set.add(s);
      }
      Arrays.sort(words, (a, b) -> a.length() != b.length()? b.length() - a.length():a.compareTo(b));
      for(int i = 0; i < words.length; i++){
         String word = words[i];
         String sub = word.substring(0,word.length() - 1);
         if(set.contains(sub)){
             while(sub.length() > 0){
             sub = sub.substring(0, sub.length() - 1);
               if(!set.contains(sub)){
                  break;
               }
             }
             if(sub.length() == 0) return word;
         
         } 
      }
      return "";
   }
   /*
    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }*/

}
