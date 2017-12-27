import java.io.*;
import java.util.*;
public class AssignCookies{
   public static void main(String [] args){
      int[]g={1, 2};
      int[]s = {1, 2, 3};
      System.out.println(findContentChildren(g, s));
   }
   public static int findContentChildren(int[] g, int[] s) {
      Arrays.sort(g);
      Arrays.sort(s);
      int count = 0;
      for(int greed : g){
         for(int i = 0; i < s.length; i++){
            if(greed <= s[i]){
               count++;
               s[i] = 0;
               break;
            }
         }
      }
      return count;
   }
}