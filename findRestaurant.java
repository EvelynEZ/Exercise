import java.io.*;
import java.util.*;
//redundant nums

public class findRestaurant{
   public static void main(String [] args) {
      String[] list1 = {"Shogun", "KFC", "Burger King", "CaffeOnTheAve"};
      String[] list2 = {"KFC", "Shogun", "Burger King"};
      String[] found = findRestaurant(list1, list2);
      for(String res: found){
         System.out.println(res);
      }
   }

   
   public static String[] findRestaurant(String[] list1, String[] list2) {
      List<String> result = new LinkedList<>();
      if(list1.length == 0 || list2.length == 0) 
         return result.toArray(new String[0]);
      int minSum = 2000;
      List<String> l2 = Arrays.asList(list2);
      for(int i = 0; i < list1.length; i++){
         int index = l2.indexOf(list1[i]);
         if(index == -1) 
            continue;
         if(index + i < minSum){
            result.clear();
            result.add(list1[i]);
            minSum = index + i;
         } else if(index + i == minSum){
            result.add(list1[i]);
         }
      }
      return result.toArray(new String[result.size()]);
   }
}