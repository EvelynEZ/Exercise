/*406. Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), where h
 is the height of the person and k is the number of people in 
 front of this person who have a height greater than or equal 
 to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.*/
import java.io.*;
import java.util.*;
public class QueueReconstruction{
   public static void main(String[] args){
      //int[][] queue = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
      int[][] queue = {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
      queue = reconstructQueue(queue);
      for(int[] person : queue) {
            System.out.print("[" + person[0] + ", " + person[1] + "] ");
         
      }
   }
   public static int[][] reconstructQueue(int[][] people) {
      Arrays.sort(people, (a, b)->b[0]==a[0]?a[1]-b[1]:b[0] - a[0]);
      List<int []> list = new ArrayList<>();
      for(int i = 0; i < people.length; i++){
         int[] person = people[i];
         int index = person[1];
         list.add(index, person);
      }
      int[][] res = new int[people.length][2];
      for(int i = 0; i < people.length; i++){
         res[i] = list.get(i);           
      }
      return res;
   }
}