import java.io.*;
import java.util.*;
public class ClassSchedule{
   public static void main(String[] args){
      int[][] schedule = {{1, 0}, {0, 2}};
      System.out.println(canFinish(3, schedule));
   }
   public static boolean canFinish(int numCourses, int[][] prerequisites) {
      List<Integer> order = new ArrayList<>();
      //get indegree
      int[] indegrees = new int[numCourses];
      for(int i = 0; i < prerequisites.length; i++){
         indegrees[prerequisites[i][0]]++;
      }
      //bfs
      Queue<Integer> startClasses = new LinkedList<>();
      for(int i = 0; i < numCourses; i++){
         if(indegrees[i] == 0) startClasses.offer(i);
      }
      while(!startClasses.isEmpty()){
         int cur = startClasses.poll();
         order.add(cur);
         for(int i = 0; i < prerequisites.length; i++){
            if(prerequisites[i][1] == cur){
               indegrees[prerequisites[i][0]]--;
               if(indegrees[prerequisites[i][0]] == 0) startClasses.offer(prerequisites[i][0]);
            }
         }
      }
      //check indegree
      for(int j = 0; j < numCourses; j++){
         if(indegrees[j] != 0) return false;
      }
      for(int course: order){
         System.out.print(course + " ");
         
      }
      return true;
   }
}
