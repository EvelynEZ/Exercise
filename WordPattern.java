import java.io.*;
import java.util.*;

public class WordPattern {
   public static void main(String [] args) {
      System.out.println(wordPattern("abba", "dog dog dog dog"));
   
   }

   public static boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0) return false;
        Map<Character, String> map = new HashMap<>();
        String[] split = str.split(" ");
        List<String> words = new ArrayList<>();
        if(pattern.length() != split.length) return false;
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(split[i])){
                return false;
                }
            } else{
               if(words.contains(split[i])) return false;
               words.add(split[i]);
                map.put(ch, split[i]);
            }
        }
        return true;
    }

}