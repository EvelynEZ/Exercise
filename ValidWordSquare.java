import java.io.*;
import java.util.*;
public class ValidWordSquare{
   public static void main(String [] args){
      String[] s= {"area","lead","wall","lady","ball"};
      //String[] s = {"abat","baba","atan","atal"};
      //String[] s = {"aa"};
      List<List<String>> res = wordSquares(s);
      for(List<String> l : res){
         for(String ss : l){
            System.out.print(ss + " ");
         }
         System.out.println();
      }
   }
   
   public static List<List<String>> wordSquares(String[] words) {
      List<List<String>> ret = new ArrayList<List<String>>();
      if(words.length==0 || words[0].length()==0) 
         return ret;
      Map<String, Set<String>> map = new HashMap<>();
      int squareLen = words[0].length();
        // create all prefix
      for(int i=0;i<words.length;i++){
         for(int j=0;j <= words[0].length();j++){
            String prefix = words[0].substring(0, j);
            if(!map.containsKey(prefix)) map.put(prefix, new HashSet<String>());
            map.get(prefix).add(words[i]);
         }
      }
      helper(ret, new ArrayList<String>(), 0, squareLen, map);
      return ret;
   }
   public static void helper(List<List<String>> ret, List<String> cur, int matched, int total, Map<String, Set<String>> map){
      if(matched == total) {ret.add(new ArrayList<String>(cur));
         return;}
        // build search string
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<=matched-1;i++) sb.append(cur.get(i).charAt(matched));
        // bachtracking
      Set<String> cand = map.get(sb.toString());
      if(cand==null) 
         return;
      for(String str:cand){
         cur.add(str);
         helper(ret, cur, matched+1, total, map);
         cur.remove(cur.size()-1);
      }
   }
}