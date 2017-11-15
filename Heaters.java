import java.io.*;
import java.util.*;

public class Heaters{
   public static void main(String [] args) {
      int[] houses = {1, 5};
      int[] heaters = {10};
      System.out.println(findRadius(houses, heaters));
   }
   public static int findRadius(int[] houses, int[] heaters) {
      Arrays.sort(houses);
      Arrays.sort(heaters);
        
      int i = 0, j = 0, res = 0;
      while (i < houses.length) {
         while (j < heaters.length - 1
                && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
            j++;
         }
         res = Math.max(res, Math.abs(heaters[j] - houses[i]));
         i++;
      }
        
      return res;
   }

}