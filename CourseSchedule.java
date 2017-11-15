import java.io.*;
import java.util.*;


public class CourseSchedule{
   public static void main(String[] args){
   //prereq for 0 is 1, prereq for 1 is 2.
      int[][] prerequisites={{0, 1}, {1,0}};
      int[] order = findOrder(2, prerequisites);
      if(order.length == 0) {
         System.out.println("Impossible");
      }else{
         for(int i = 0; i < order.length; i++){
            System.out.println(" " + order[i]);
         }
      }
   }
  
   public static int[] findOrder(int numCourses, int[][] prerequisites) {
      int[] order = new int[numCourses];
      //1.inDegree
      int[] indegree = new int[numCourses];
      for(int i = 0; i < prerequisites.length; i++){
         indegree[prerequisites[i][0]]++;
      }
      //2. generate start classes (classes with 0 indegree)
      Queue<Integer> startClass = new LinkedList<>();
      for(int j = 0; j <numCourses; j++){
         if(indegree[j] == 0){
            startClass.offer(j);
         }
      }
      //3. bfs
      int count=0;
      while(!startClass.isEmpty()){
         int course = startClass.poll();
         order[count] = course;
         count++;
         for(int h = 0; h < prerequisites.length; h++){
            if(course == prerequisites[h][1]){
               indegree[prerequisites[h][0]]--;
               if(indegree[prerequisites[h][0]] == 0){
                  startClass.offer(prerequisites[h][0]);
               }
            }
         }
      }
      for(int k = 0; k < numCourses; k++){
         if(indegree[k] != 0){
            return new int[0];
         }
      }
      return order;    
   }

}