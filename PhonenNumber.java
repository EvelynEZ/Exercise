import java.io.*;
import java.util.*;
public class PhonenNumber{
   public static void main(String [] args) {
      String number = "234";
      System.out.println(letterCombinations(number).toString());
   }
   public static List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if(digits.length() == 0) return result;
      int index = 0;
      digits = digits.substring(index);
      String[] letters = {"", "" ,"abc", "def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      StringBuilder sb = new StringBuilder();
      helper(sb, digits, 0, result, letters);
      return result;
   }
   
   private static void helper(StringBuilder sb, String digits, int index, List<String> result, String[] letters){
      if(sb.length() == digits.length()){
         String combination = sb.toString();
         result.add(combination);
         return;  
      }
      for(int i = index; i < digits.length(); i++) {
         int number = digits.charAt(i) - '0';
         if(number < 0 ||  number > 9) continue; // if it's not number
         for(int j = 0; j < letters[number].length(); j++) {
            sb.append(letters[number].charAt(j));
            helper(sb, digits, i+1, result, letters);
            sb.deleteCharAt(sb.length() - 1);
         }
      }   
   }
}