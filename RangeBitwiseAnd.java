import java.io.*;
import java.util.*;

public class RangeBitwiseAnd{
   public static void main(String [] args) {
      
      System.out.println(rangeBitwiseAnd(5, 7));
   }
   /*public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) return 0;
        int result = m;
        for(int i = m + 1; i <= n; i++){
            result = result & i;
        }
        return result;
    }*/
   public static int rangeBitwiseAnd(int m, int n){
      if(m == 0) 
         return 0;
      int mask = Integer.MAX_VALUE;
      while((m&mask) != (n&mask)){
         mask = mask << 1;
      }
      return m&mask;
   }
     
}