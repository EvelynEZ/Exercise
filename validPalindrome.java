import java.io.*;
import java.util.*;
public class validPalindrome{
   public static void main(String [] args) {
      String s = "01";
      System.out.println(isPalindrome(s));
   }
    public static boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while(i < j){
            char left = s.charAt(i); 

            if(left != right){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}