import java.io.*;
import java.util.*;
public class keyboardRow{
   public static void main(String [] args) {
      String[] str = {"asdfghjkla","qwertyuiopq","zxcvbnzzm","asdfghjkla","qwertyuiopq","zxcvbnzzm"};
      String[] result = findWords(str);
      for(String s:result) {
         System.out.println(s);
      }
   }
   
   public static String[] findWords(String[] words) {
        if(words.length == 0) return new String[0];
        Map<Character, Integer> map = new HashMap<>();
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < strs[i].length(); j++){
                map.put(strs[i].charAt(j), i);
            }
        }
        List<String> result = new ArrayList<>();
        for(String word: words){
            int index = 0;
            for(index = 0; index < word.length() - 1; index++){
                if(map.get(word.toUpperCase().charAt(index)) != map.get(word.toUpperCase().charAt(index + 1))){
                    index = -1;
                    break;
                }
            }
            if(index != -1){
               result.add(word);
            }
        }
        String[] arr = new String[result.size()];
        int i = 0;
        for(String word:result){
            arr[i++] = word;
        }
        return arr;
    }
   
}