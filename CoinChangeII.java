/*You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
*/
import java.io.*;
import java.util.*;
public class CoinChangeII {
   public static void main(String[] args){
      int[] coins = {1,2, 5};
      System.out.println(change(10, coins));
   }
   public static int change(int amount, int[] coins) {
      if(amount <= 0) 
         return 1;
      if(coins.length == 0) 
         return 0;
      int[]dp = new int[amount+1];
      dp[0] = 1;
      for(int value : coins){
         for(int j = 1; j <= amount; j++){
            if(j >= value){
               dp[j] += dp[j-value];
            }
         }
      }
      return dp[amount];
   }

}
