//Notice: upper and lower cases should be taken into consideration.
//to include the condition?A:B term, it is necessary to add parenthesis.
import java.io.*;
import java.util.*;
public class ReverseVowel{
   public static void main(String[] args) {
      String s = "leEtcode";
      System.out.println(reverseVowels(s));
   }
   public static String reverseVowels(String s) {
      Set<Character> vowels = new HashSet<>();
      vowels.add('a');
      vowels.add('e');
      vowels.add('i');
      vowels.add('o');
      vowels.add('u');
      int i = 0, j = s.length() - 1;
      while(i < j){
         while(i<j && !vowels.contains(s.toLowerCase().charAt(i))){
            i++;
         }
         while(i<j && !vowels.contains(s.toLowerCase().charAt(j))){
            j--;
         }
         if(i < j) {
            char temp = s.charAt(j);
            s = s.substring(0, j) + s.charAt(i) + (((j+1)<s.length())?s.substring(j+1):"");
            s = s.substring(0, i) + temp + s.substring(i+1);
         }
         i++;
         j--;
      }
      return s;
   }
   
   
}