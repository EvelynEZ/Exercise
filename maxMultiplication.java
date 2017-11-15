import java.io.*;
import java.util.*;


/*
If there is negative number:
   if there is only one negative number -> multiplication of pos nums are max
   if there are more thna one neg num -> check if min1(-)*min2(-)*max1(+) is greater than max1*max2*max3
*/
public class maxMultiplication{
   public static void main(String [] args) {
      int[] nums = {1, 2, 3, 2};
      System.out.println(maximumProduct(nums));
   }
   public static int maximumProduct(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null, min1 = null, min2 = null;
        for(int n: nums){
            if(max1 == null || n > max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if(max2 == null || n > max2){
                max3 = max2;
                max2 = n;
            } else if(max3 == null || n > max3){
                max3 = n;
            }
            
            if(min1 == null || n < min1){
                min2 = min1;
                min1 = n;
            } else if(min2 == null || n < min2){
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}