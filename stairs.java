import java.io.*;
import java.util.*;


public class stairs {
   public static void main(String [] args) {
      System.out.println(climbStairs(3));
   
   }

   public static int climbStairs(int stair) {
      int a = 1; //ways to get to this step.
      int b = 1; //ways to complete next step.
      while (stair > 0) {
         int temp = b;
         b = b + a;
         a = temp;
         stair--;
      }
      return a;
   }
}