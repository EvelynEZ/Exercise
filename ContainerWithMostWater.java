/*Given n non-negative integers a1, a2, ..., an, where each represents a 
point at coordinate (i, ai). n vertical lines are drawn such that the two 
endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

import java.io.*;
import java.util.*;
public class ContainerWithMostWater{
   public static void main(String [] args){
      int[] height = {2, 1, 3, 1, 2};
      System.out.println(maxArea(height));
   }
   /*
   //O(n^2)
   public static int maxArea(int[] height) {
      int max = 0;
      int len = height.length;
      for(int i = 0; i < len - 1; i++){
         for(int j = i+1; j < len; j++){
            max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
         }
      }
      return max;
   }*/
   
   //O(n)
   public static int maxArea(int[] height){
      int left = 0, right = height.length - 1;
      int max = 0;
      while(left < right){
         max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
         if(height[left] < height[right]){
            left++;
         } else {
            right--;
         }
      }
      return max;
   }  
}