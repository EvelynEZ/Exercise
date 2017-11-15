import java.io.*;
import java.util.*;
public class WordLadder{
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
      System.out.println(ladderLength(beginWord, endWord, wordList));
   }
   
   public static int ladderLength(String startWord, String endWord, List<String> wordList) {
      if(wordList == null) 
         return 0;
      if(startWord.equals(endWord)) 
         return 1;
      
      wordList.add(startWord);
      
      Set<String> hash = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      
      queue.offer(startWord);
      hash.add(startWord);
      
      int length = 1;
      while(!queue.isEmpty()){
         length++;
         int size = queue.size();
         for(int i = 0; i < size; i++){
            String word = queue.poll();
            for(String nextWord: getNextWord(word, wordList)){
               if(hash.contains(nextWord)) 
                  continue;
               if(nextWord.equals(endWord)) 
                  return length;
               
               queue.offer(nextWord);
               hash.add(nextWord);            
            }
         }
      }
      return 0;
   }
   
   public static List<String> getNextWord (String word, List<String> wordList){
      List<String> result = new ArrayList<>();
            
      for(int index = 0; index < word.length(); index++){
         for(char c = 'a';  c<'z'; c++){
            String newWord = word.substring(0, index) + c + word.substring(index + 1, word.length());
            if(wordList.contains(newWord)){
               result.add(newWord);
            }
         }
      }
      return result;
     /* for(String nextWord: wordList){
         if(isConnected(word, nextWord)){
            result.add(nextWord);
         }
      }

      return result;*/
   }

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