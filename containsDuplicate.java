import java.io.*;
import java.util.*;

public class containsDuplicate{
   public static void main(String [] args) {
      int[] nums = {-2147483648,-2147483647};
      System.out.println(containsNearbyAlmostDuplicate(nums,3, 3));
   }
   public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            Long floor = values.floor((long)(nums[ind] + t));
            Long ceil = values.ceiling((long)(nums[ind] - t));
            if ((floor != null && floor >= (long)nums[ind])
                    || (ceil != null && ceil <= (long)nums[ind])) {
                return true;
            }

            values.add((long)nums[ind]);
            if (ind >= k) {
                values.remove((long)(nums[ind - k]));
            }
        }

        return false;
    } 
   
}