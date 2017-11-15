import java.io.*;
import java.util.*;
public class WordLadderII{
   public static void main(String[] args) {
      String beginWord = "hit";
      String endWord = "cog";
      List<String> wordList = new ArrayList<>();
      wordList.add("hot");
      wordList.add("dot");
      wordList.add("dog");
      wordList.add("lot");
      wordList.add("log");
      wordList.add("cog");
      List<List<String>> result = findLadders(beginWord, endWord, wordList);
      for(List<String>list: result){
         System.out.println(list.toString());
      }
   }
   
   
   public static List<List<String>> findLadders(String startWord, String endWord, List<String> wordList) {
      List<List<String>> ladders = new ArrayList<>();
      if(wordList.contains(endWord)){
         return ladders;
      }
      //map the word with connected words.
      Map<String, List<String>> map = new HashMap<>();
      //map the word with its distance to the start.
      Map<String, Integer> distance = new HashMap<>();
      
      wordList.add(startWord);
      
      //Fill in map, and distance.
      bfs(map, distance, startWord, endWord, wordList);
      
      List<String> path = new ArrayList<>();
      //add endWord to path since we are backtracing.
      path.add(endWord);
      
      //find each path. 
      dfs(ladders, path, startWord, endWord, distance, map);
      return ladders;
   }
   
   
   public static void dfs(List<List<String>> ladders, List<String> path, String start, String crt, Map<String, Integer> distance, Map<String,List<String>> map){
      if(crt.equals(start)){
         Collections.reverse(path);
         ladders.add(new ArrayList<String> (path));
         Collections.reverse(path);
         return;
      }  
      
      for(String next: map.get(crt)){
         //makes sure that crt is closer to the start.
         if(distance.get(crt) == distance.get(next)+1){
            path.add(next);
            dfs(ladders, path, start, next, distance, map);
            path.remove(path.size() - 1);
         }
      }
      
      
   }
   public static void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, List<String> wordList) {
      Queue<String> q = new LinkedList<>();
      q.offer(start);
      distance.put(start, 0);
      for(String s: wordList) {
         map.put(s, new ArrayList<String>());
      }
      while(!q.isEmpty()){
         String crt = q.poll();
         List<String> nextWords = getNextWord(crt, wordList);
         for(String next: nextWords){
            map.get(next).add(crt);
            if(!distance.containsKey(next)){
               distance.put(next, distance.get(crt)+1);
               q.offer(next);
            }
         }
      }
   }
   
   //return a list of strings that are connected with the word.
   public static List<String> getNextWord (String word, List<String> wordList){
      List<String> result = new ArrayList<>();
      for(String nextWord: wordList){
         if(!word.equals(nextWord) && isConnected(word, nextWord)){
            result.add(nextWord);
         }
      }
      return result; 
   }

   //check if two words are connected.
   public static boolean isConnected (String word, String nextWord){
      boolean connected = true;
      int changedIndex = 0;
      for(int i = 0; i < word.length(); i++){
         if(word.charAt(i) != nextWord.charAt(i)){
            changedIndex ++;
            if(changedIndex > 1){
               connected = false;
               break;
            }
         }
      }
      return connected;
   }
}