import java.io.*;
import java.util.*;
public class CountBinarySubstring{
   public static void main(String[] args){
    System.out.print(countBinarySubstrings("10101"));
   }
   
   public static int countBinarySubstrings(String s) {
        int len = s.length();
        int result = 0;
        if(len < 2) return 0;
        int curLength = 1, preLength = 0;
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == s.charAt(i-1)) curLength++;
            else {
                preLength = curLength;
                curLength = 1;
            }
            if(preLength >= curLength) result++;
        }
        return result;
    }
   /*
   //Time Limit
   public static int countBinarySubstrings(String s) {
        int len = s.length();
        int result = 0;
        if(len < 2) return 0;
        int[] count = new int[2];
        for(int i = 0; i < len; i++){
            count[0] = 0;
            count[1] = 0;
            int curi = s.charAt(i) - '0';
            count[curi]++;
            for(int j = i+1; j < len; j++){
                int curj = s.charAt(j) - '0';
                if(s.charAt(j) != s.charAt(j-1) && count[curj] != 0) break; // not consecutive. 
                count[curj]++;
                if(count[0] == count[1]) result++;
            }
        }
        return result;
    }*/
}