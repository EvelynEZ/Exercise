import java.io.*;
import java.util.*;
public class ValidWordSquare{
   public static void main(String [] args){
      //String[] s= {"area","lead","wall","lady","ball"};
      //String[] s = {"abat","baba","atan","atal"};
      String[] s = {"aa"};
      List<List<String>> res = wordSquares(s);
      for(List<String> l : res){
         for(String ss : l){
            System.out.print(ss + " ");
         }
         System.out.println();
      }
   }
   
   /*public static List<List<String>> wordSquares(String[] words) {
      List<List<String>> res = new ArrayList<>();
      List<String> cur = new ArrayList<>();
      if(words.length == 1 && words[0].length() == 1) {
         cur.add(words[0]);
         res.add(cur);
         return res;
      }
      permutation(res, cur, words);
      return res;
   }
    
   public static void permutation(List<List<String>> res, List<String> cur, String[] words){
      if(cur.size() == words[0].length()){
         if(checkSquare(cur)) res.add(new ArrayList<String>(cur));
         return;
      }
      for(int i = 0; i < words.length; i++){
         cur.add(words[i]);
         if(checkSquare(cur)) {
            permutation(res, cur, words);
         }
         cur.remove(cur.size() - 1);
      }
   }
    
   public static boolean checkSquare(List<String> block){
      int index = block.size() - 1;
      for(int j = 0; j < block.size(); j++){
         char a = block.get(index).charAt(j);
         char b = block.get(j).charAt(index);
         if(a != b) 
            return false;
      }            
      
      return true;
   }*/
   public static List<List<String>> wordSquares(String[] words) {
      List<List<String>> ret = new ArrayList<List<String>>();
      if(words.length==0 || words[0].length()==0) 
         return ret;
      Map<String, Set<String>> map = new HashMap<>();
      int squareLen = words[0].length();
        // create all prefix
      for(int i=0;i<words.length;i++){
         for(int j=-1;j<words[0].length();j++){
            if(!map.containsKey(words[i].substring(0, j+1))) map.put(words[i].substring(0, j+1), new HashSet<String>());
            map.get(words[i].substring(0, j+1)).add(words[i]);
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