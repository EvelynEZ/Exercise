/*
S.length = T.length 
and
S[i] = T[i] + K for 
1 <= i <= S.length  for a constant integer K


Example: 
Input  : str[] = {"acd", "dfg", "wyz", "yab", "mop",
                 "bdfh", "a", "x", "moqs"};

Output : a x
         acd dfg wyz yab mop
         bdfh moqs
All shifted strings are grouped together.
*/
import java.io.*;
import java.util.*;

public class GroupShiftedString {
   public static void main(String [] args) {
      String [] s = {"acd", "dfg", "wyz", "yab", "mop",
                 "bdfh", "a", "x", "moqs"};
      List<List<String>> result = groupShiftedString(s);
      for(List<String> list:result) {
         System.out.println(list.toString());      
      }
   }
   
   public static List<List<String>> groupShiftedString(String[] s) {
      List<List<String>> result = new ArrayList<>();
      if(s.length == 0) 
         return result;
      Map<String, List<String>> map = new HashMap<>();
      for(String str: s) {
         int shift = str.charAt(0) - 'a';
         StringBuilder key = new StringBuilder();
            
         for(int i=0;i< str.length();i++){
            key.append((char)(str.charAt(i)+26-shift)%26);
         }
         String k = key.toString();
         if(map.containsKey(k)){
            map.get(k).add(str);
         } else {
            map.put(k, new ArrayList<String>());
            map.get(k).add(str);
         }
      }
      result.addAll(map.values());
      return result;
   
   }
   


}