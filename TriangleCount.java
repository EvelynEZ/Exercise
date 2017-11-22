/*
Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?
Example
Given array S = [3,4,6,7], return 3. They are:
[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:
[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]

Condition for triangle: a+b>c
*/
import java.io.*;
import java.util.*;
public class TriangleCount{
   public static void main(String[] args) {
       int[] a = {4, 4, 4, 4};
       System.out.println(triangleCount(a));
   }
   
   public static int triangleCount(int[] a){
      if(a.length < 3)return 0;
      Arrays.sort(a);
      int ans = 0;
      for(int i = 0; i < a.length; i++) {
         int left = 0, right = i-1;
         while(left < right) {
            if(a[left] + a[right] > a[i]){
               ans += right - left;
               right--;
            } else {
               left++;
            }
         }
      }
      return ans;
   }
}