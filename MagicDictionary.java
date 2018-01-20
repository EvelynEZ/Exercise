import java.io.*;
import java.util.*;
class MagicDictionary {
   Set<String> dict;
    /** Initialize your data structure here. */
   public MagicDictionary() {
      dict = new HashSet<>();
        
   }
    
    /** Build a dictionary through a list of words */
   public void buildDict(String[] dict) {
      for(String w : dict){
         this.dict.add(w);
      }
        
   }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
   public boolean search(String word) {
      for(String s : dict){
         if(s.length() != word.length()) 
            continue;
         int diff = 0;
         for(int i = 0; i < word.length(); i++){
            if(s.charAt(i) != word.charAt(i)) diff++;
            if(diff > 1) 
               break;
         }
         if(diff == 1) 
            return true;
      }
      return false;
   }
}