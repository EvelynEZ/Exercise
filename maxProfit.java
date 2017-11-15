import java.io.*;
import java.util.*;
public class maxProfit{
   public static void main(String [] args) {
      int[] prices = {7,1,5,3,6,4};
      System.out.println(maxProfit(prices));
   }

   //long runtime
   /*public static int maxProfit(int[] prices) {
      int max = 0;
      for(int i = 0; i < prices.length - 1; i++){
         for(int j = i+1; j < prices.length; j++){
            max = Math.max(max, prices[j] - prices[i]);
         }
            
      }
      return max;
            
   }
   
   public static int maxProfit(int[] prices) {
      int max = 0;
      for(int i = 0; i < prices.length - 1; i++){
         int[] rest = Arrays.copyOfRange(prices, i+1, prices.length);
         Arrays.sort(rest);
         max = Math.max(max, rest[rest.length - 1] - prices[i]);
      }
      return max;
            
   }*/
   
   public static int maxProfit(int[] prices){
      if(prices.length < 2) return 0;
      int max = 0;;
      int min = prices[0];
      for(int i = 0; i < prices.length; i++) {
         if(prices[i] > min){
            max = Math.max(max, prices[i] - min);
         } else {
            min = prices[i];
         }   
      }
      return max;
   }
}