import java.io.*;
import java.util.*;

public class FlowerGarden{
   public static void main(String [] args) {
      int[] height = {3,2,5,4};
      int[] bloom = {1,2,11,10};
      int[] wilt = {4,3,12,13};
      int[] order = getOrder(height, bloom, wilt);
      for(int i :order) {
         System.out.print(i + " ");
      }
   }
   
   public static int[] getOrder(int [] height, int[] bloom, int[]wilt){
      int length = height.length;
      //final order result
      int[] result = new int[length];
      //if flower i is planted, then used[i] = true.
      boolean[] used = new boolean[length];
      //loop through all indicies (0 to length).
      for(int i = 0; i < length; i++) {
         //Set the maxHeight, position of maxHeight found to be -1
         int max = -1;
         int maxPosition = -1;
         //loop through all the unused flowers, with height higher than maxHeight.
         for(int j = 0; j < length; j++) {
            if(!used[j] && height[j] > max) {
               //check if the flower has blocked any of the rest flower.
               boolean blocked = false;
               for(int k = 0; k < length; k++) {
                  //if it is higher than the other left flowers
                  if(!used[k]&&height[j] > height[k]) {
                     if(wilt[k] >= bloom[j] && bloom[k] <= wilt[j]){
                        //bloom/wilt period overlapped, stop checking progress
                        blocked = true;
                        break;
                     }
                  }
               
               }
               if(!blocked) {
                  //candidate for this index.
                  max = height[j];
                  maxPosition = j;
               }
            
            }
         }
         result[i] = max;
         used[maxPosition] = true;
      }
      return result;
   }
   
}