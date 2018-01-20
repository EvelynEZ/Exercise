import java.io.*;
import java.util.*;
public class ShortestCompletingWord{
   public static void main(String [] args){
      String plate = "1s3 PSt";
      String[] words = {"step","steps","stripe","stepple"};
      System.out.println(shortestCompletingWord(plate, words));
   }
   public static String shortestCompletingWord(String licensePlate, String[] words) {
        if(licensePlate.length() == 0) return  "";
        int[] bucket = new int[26];
        for(char c : licensePlate.toCharArray()){
                c = Character.toLowerCase(c);
                if(c >= 'a' && c <= 'z'){
                    bucket[c -'a']--;
                }
        }
        String res = "";
        for(String word : words){
            int[] bucket2 = Arrays.copyOfRange(bucket, 0, 26);
            for(char c : word.toLowerCase().toCharArray()){
                bucket2[c - 'a']++;
            }
            
            int i = 0;
            for(i = 0; i < 26; i++){
                if(bucket2[i] < 0) break;
            }
            if(i == 26) {
               if(res == "" || res.length() > word.length()){
                  res = word;
               }
            }
        }
        return res;
    }
   
}