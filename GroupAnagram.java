import java.io.*;
import java.util.*;
public class GroupAnagram{
   public static void main(String[] args){
      String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
      List<List<String>> res = groupAnagrams(strs);
      System.out.println(res.toString());
   
   }
   public static List<List<String>> groupAnagrams(String[] strs) {
      int n = strs.length;
      if(n == 0) 
         return res;
      Map<String, List<String>> map = new HashMap<>();
      for(String s : strs){
         char[] ch = s.toCharArray();
         Arrays.sort(ch);
         String key = String.valueOf(ch);
         if(map.containsKey(key)){
            map.get(key).add(s);
         } else {
            List<String> newList = new ArrayList<>();
            newList.add(s);
            map.put(key, newList);
         }
      }
   
      return new ArrayList<List<String>>(map.values());
   }
   
}