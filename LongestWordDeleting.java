import java.io.*;
import java.util.*;
public class LongestWordDeleting{
   public static void main(String[] args) {
      String s = "abpcplea";
      List<String> d = new ArrayList<>();
      String[] str = {"ale","apple","monkey","plea"};
      d = Arrays.asList(str);
      System.out.println(findLongestWord(s, d));
   }
   public static String findLongestWord(String s, List<String> d) {
      Collections.sort(d, (a, b) -> a.length() != b.length()? -Integer.compare(a.length(), b.length()):a.compareTo(b));
      for(String word : d){
         int index = 0;
         for(char c: s.toCharArray()){
            if(index < word.length() && c == word.charAt(index)){
               index++;
            }
            if(index == word.length()) 
               return word;
         }
      }
      return "";
   }
}