/*
Numbers can be regarded as product of its factors. For example,
8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.
Note:
Each combination’s factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
For example:Input: 12
Output: [[2, 2, 3], [2, 6], [3, 4]]
Input: 15
Output: [[3, 5]]
Input: 28
Output: [[2, 2, 7], [2, 14], [4, 7]]
*/import java.io.*;
import java.util.*;
public class FactorCombination {
   public static void main(String[] args) {
      List<List<Integer>> result = new ArrayList<>();
      result = getFactorComb(8);
      for(List<Integer> perm : result) {
         System.out.print("[");
         for(int num: perm) {
            System.out.print(num + ", ");
         }
         System.out.println("]");
      }
   }
   
   public static List<List<Integer>> getFactorComb (int num){
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> perm = new ArrayList<>();
      if(num < 1){
         perm.add(num);
         result.add(perm);
         return result;
      }
      helper(num, result, perm, 2);
      return result;
   }
   
   public static void helper(int num, List<List<Integer>> result, List<Integer> perm, int startIndex){
      if(num == 1){
         result.add(new ArrayList<Integer>(perm));
         return;
      }
      for(int i = startIndex; i <= num; i++){
         if(num%i != 0) continue;
         perm.add(i);
         helper(num/i, result, perm, i);
         perm.remove(perm.size() - 1);
      }
   }
}