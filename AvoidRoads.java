import java.io.*;
import java.util.*;

public class AvoidRoads{
   public static void main(String [] args) {
      String[] bad = {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
      System.out.println(findNumPath(2, 2, bad));
   }
   
   public static long findNumPath(int w, int h, String[] bad){
      if(w == 1 && h == 1) return 1;
      long[][] dp = new long[w+1][h+1];
      dp[0][0] = 1;
      for(int x = 0; x <= w; x++) {
         for(int y = 0; y <= h; y++) {
            if(x > 0){
               if(!blocked(x-1, y, x, y, bad)){
                  dp[x][y] += dp[x-1][y];
               }
            }
            if(y > 0){
               if(!blocked(x, y-1, x, y, bad)){
                  dp[x][y] += dp[x][y-1];
               }
            }
         }
      }
      return dp[w][h];
   }
   
   public static boolean blocked(int x1, int y1, int x2, int y2, String[] bad){
      String[][] pos = new String[bad.length][4];
      for(int i = 0; i < bad.length; i++) {
         pos[i] = bad[i].split(" ");    
      }
      for(int i = 0; i < pos.length; i++) {
         if(Integer.parseInt(pos[i][0]) == x1 
            && Integer.parseInt(pos[i][1]) == y1
            && Integer.parseInt(pos[i][2]) == x2
            && Integer.parseInt(pos[i][3]) == y2
            ){
            return true;
         }
         if(Integer.parseInt(pos[i][0]) == x2 
            && Integer.parseInt(pos[i][1]) == y2
            && Integer.parseInt(pos[i][2]) == x1
            && Integer.parseInt(pos[i][3]) == y1) {
            
            return true;
         }
      }
      return false;
   
   }
}