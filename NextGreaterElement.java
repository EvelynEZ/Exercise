import java.io.*;
import java.util.*;
public class NextGreaterElement{
   public static void main(String[] args){
      int[] nums1 = {4,1,2};
      int[] nums2 = {1,3,4,2};
      for(int num :nextGreaterElement(nums1, nums2)) {
         System.out.print(num + " ");
      }
      
   }
   public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int[] result = new int[nums1.length];
      Arrays.fill(result, -1);
      if(nums1.length > nums2.length) 
         return result;
      for(int j = 0; j < nums1.length; j++){
         int num = nums1[j];
         //int index = Arrays.asList(nums2).indexOf(num); 
         //TC: O(N) and require Integer[] nums2
         int index = 0; 
         for(int k = 0; k < nums2.length; k++){
            if(nums2[k] == num){
               index = k;
               break;
            }
         }
         for(int i = index+1; i < nums2.length; i++){
            if(nums2[i] > num){
               result[j] = nums2[i];
               break;
            }
         }
      }
      return result;
   }
}