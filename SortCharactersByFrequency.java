import java.io.*;
import java.util.*;
public class SortCharactersByFrequency{
   public static void main(String[] args){
      String s = "Abab";
      System.out.println(frequencySort(s));
   }
   public static String frequencySort(String s) {
      Map<Character, Integer> map1 = new HashMap<>();
      for(char c : s.toCharArray()){
         if(map1.containsKey(c)){
            map1.put(c, map1.get(c)+1);
         } else {
            map1.put(c, 1);
         }
      }
      Map<Integer, List<Character>> map2 = new HashMap<>();
      for(char c : map1.keySet()){
         if(map2.containsKey(map1.get(c))){
            map2.get(map1.get(c)).add(c);
         } else {
            List<Character> list = new ArrayList<>();
            list.add(c);
            map2.put(map1.get(c), list);
         }
      }
      StringBuilder sb = new StringBuilder();
      while(!map2.isEmpty()){
         int max = 0;
         for(int n : map2.keySet()){
            if(n > max) max = n;
         }
         for(int i = 0; i < map2.get(max).size(); i++){
            char c = map2.get(max).get(i);
            for(int j = 0; j < max; j++){
               sb.append(c);
            } 
         }
         map2.remove(max);
      }
      return sb.toString();
   }
}