import java.io.*;
import java.util.*;

public class CanFinish{
   public static void main (String[] args) {
      //prereq for 0 is 1, prereq for 1 is 2.
      int[][] prerequisites={{0, 1}, {1,0}};
      System.out.println(canFinish(3, prerequisites));
   }
   public static boolean canFinish(int numCourses, int[][] prerequisites) {
      //Indegree of each class.
      int[] indegree = new int[numCourses];
      for(int i = 0;i < prerequisites.length; i++){
         indegree[prerequisites[i][0]]++;
      }
      //Set up a queue with all the classes without prereq.
      Queue<Integer> startClass = new LinkedList<>();
      for (int j = 0; j < numCourses; j++) {
         if(indegree[j] == 0){
            startClass.offer(j);
         }
      }
      //bfs
      while(!startClass.isEmpty()){
         int course = startClass.poll();
         for(int h = 0; h < prerequisites.length; h++) {
            if(prerequisites[h][1] == course) {
               indegree[prerequisites[h][0]]--;
               if(indegree[prerequisites[h][0]] == 0) {
                  startClass.offer(prerequisites[h][0]);
               }
            }
            
         }
      }
      for(int k = 0; k < numCourses; k++) {
         if(indegree[k] != 0) {
            return false;
         }
      }
      return true;
   }  

}