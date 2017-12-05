/*
Leetcode 403. Frog Jump:
A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

Note:

The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.
Example 1:

[0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping 
1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
2 units to the 4th stone, then 3 units to the 6th stone, 
4 units to the 7th stone, and 5 units to the 8th stone.

[0,1,2,3,4,8,9,11]

Return false. There is no way to jump to the last stone as 
the gap between the 5th and 6th stone is too large.
*/

import java.io.*;
import java.util.*;
public class FrogJump {
   //private static boolean[] dp;
   public static void main(String[] args){
      int[] stones = {0,1,3,6,10,13,15,18};
      System.out.println(canCross(stones));
   }
   public static boolean canCross(int[] stones) {
      if(stones.length == 1) 
         return true;
      if(stones[1] != 1) 
         return false;
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < stones.length; i++) {
         if (i > 3 && stones[i] > stones[i - 1] * 2) 
            return false; // The two stones are too far away. 
         set.add(stones[i]);
      }
      int lastStone = stones[stones.length - 1];
      return helper(set, lastStone, 1, 1);
   }
   
   public static boolean helper(Set<Integer> set, int lastStone, int pos, int unit){
      if(pos == lastStone) 
         return true;
      if(set.contains(pos + unit + 1)){
         if(helper(set, lastStone, pos+unit+1, unit+1)) 
            return true;
      }
      if(set.contains(pos + unit)){
         if(helper(set, lastStone, pos+unit, unit)) 
            return true;
      }
      if(unit > 1 && set.contains(pos + unit - 1)){
         if(helper(set, lastStone, pos+unit-1, unit-1)) 
            return true;
      }
      return false;
   }

   /*
   //Time Limit
   public static boolean canCross(int[] stones) {
      if(stones.length == 1) return true;
      if(stones[1] != 1) return false;
      return helper(stones, 1, 1);
   }
   
   public static boolean helper(int[] stones, int stoneIndex, int unit){
      if(stoneIndex == stones.length - 1) return true;
      boolean canJump = false;
      for(int i = stoneIndex + 1; i < stones.length; i++) {
         if(stones[i] < stones[stoneIndex]+unit-1) continue;
         if(stones[i] > stones[stoneIndex]+unit+1) break;
         if(stones[i] == stones[stoneIndex] + unit + 1){
            canJump = helper(stones, i, unit+1);
         }
         if(canJump) return true;
         if(stones[i] == stones[stoneIndex] + unit){
            canJump = helper(stones, i, unit);
         }
         if(canJump) return true;
         if(stones[i] == stones[stoneIndex] + unit - 1){
            canJump = helper(stones, i, unit-1);
         }
         if(canJump) return true;
      }
      return false;
   }
   
   
   //Time Limit
   public static boolean canCross(int[] stones) {
      if(stones.length == 1) return true;
      if(stones[1] != 1) return false;
      dp = new boolean[stones.length];
      dp[0] = true;
      dp[1] = true;
      helper(stones, 1, 1);
      return dp[stones.length-1];
   }
   
   public static void helper(int[] stones, int stoneIndex, int unit){
      for(int i = stoneIndex + 1; i < stones.length; i++) {
         if(stones[i] == stones[stoneIndex] + unit - 1) {
            dp[i] = true;
            helper(stones, i, unit-1);
         }
         if(stones[i] == stones[stoneIndex] + unit) {
            dp[i] = true;
            helper(stones, i, unit);
         }
         if(stones[i] == stones[stoneIndex] + unit + 1) {
            dp[i] = true;
            helper(stones, i, unit+1);
         }
      }
   }
   */
}