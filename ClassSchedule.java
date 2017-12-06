import java.io.*;
import java.util.*;
public class ClassSchedule{
   public static void main(String[] args){
      int[][] schedule = {{1, 0}, {0, 1}};
      System.out.println(canFinish(2, schedule));
   }
   public static boolean canFinish(int numCourses, int[][] prerequisites) {
      Map<Integer, Set<Integer>> map = new HashMap<>();
      for(int[] pairs : prerequisites){
         int course = pairs[0], pre = pairs[1];
         if(map.containsKey(course)){
            map.get(course).add(pre);
            while(map.containsKey(pre)){
               if(map.get(pre).contains(course)) return false;
               for(int 
            }
         }
      }
   }
}
