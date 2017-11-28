import java.io.*;
import java.util.*;
public class WordBreakII{
   public static HashMap<String,List<String>> map = new HashMap<String,List<String>>();

   public static void main(String[] args){
      List<String> dic = new ArrayList<>();
      dic.add("cat"); 
      dic.add("and");
      dic.add("sand");
      dic.add("dog");
      dic.add("cats");
      dic.add("s");
      String s = "catsanddog";
      List<String> result = wordBreak(s, dic);
      System.out.print(result.toString());
   }
   //Method1, DFS with memorization
   public static List<String> wordBreak(String s, List<String> wordDict) {
      List<String> res = new ArrayList<String>();
      if(s == null || s.length() == 0) {
         return res;
      }
      if(map.containsKey(s)) {
         return map.get(s);
      }
      if(wordDict.contains(s)) {
         res.add(s);
      } 
      for(int i = 1 ; i < s.length() ; i++) {
         String t = s.substring(i);
         if(wordDict.contains(t)) {
            List<String> temp = wordBreak(s.substring(0 , i) , wordDict);
            if(temp.size() != 0) {
               for(int j = 0 ; j < temp.size() ; j++) {
                  res.add(temp.get(j) + " " + t);
               }
            }
         }
      }
        
      map.put(s , res);
      return res;
   }   /*
   //Method 2:"baaaaaaaa...aaaa" dic:[a, aa, aaa...,aaaaaaa..aa] TLE
   public static List<String> wordBreak(String s, List<String> wordDict) {
      List<String> result = new ArrayList<>();
      if(s.length() == 0 || wordDict.size() == 0) 
         return result;
      helper(s, wordDict, result, "");
      return result;
   }
    
   public static void helper(String s, List<String> wordDict, List<String> result, String curr){
      if(s.length() == 0) {
         result.add(curr.trim());
         return;
      }
      for(int i = 1; i <= s.length(); i++){
         if(wordDict.contains(s.substring(0, i))){
            curr += " " + s.substring(0, i);
            helper(s.substring(i), wordDict, result, curr);
            curr = curr.substring(0, curr.length() - i);
         }
      }
   }*/
}