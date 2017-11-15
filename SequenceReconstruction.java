import java.io.*;
import java.util.*;

/*Check whether the original sequence org can be uniquely reconstructed from the 
sequences in seqs. The org sequence is a permutation of the integers from 1 to n,
with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of
the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are
subsequences of it). Determine whether there is only one sequence that can be 
reconstructed from seqs and it is the org sequence.

Example 1:

Input:
org: [1,2,3], seqs: [[1,2],[1,3]]

Output:
false

Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] 
is also a valid sequence that can be reconstructed.

Example 2:

Input:
org: [1,2,3], seqs: [[1,2]]

Output:
false

Explanation:
The reconstructed sequence can only be [1,2].
Example 3:

Input:
org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

Output:
true

Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input:
org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

Output:
true
*/
public class SequenceReconstruction{
   public static void main(String[] args){
      int[] org = {1, 2, 3};
      int[][] seqs={{1, 2}, {1, 3}};
      System.out.println(sequenceReconstruction(org, seqs));
   }
   /*
   private static boolean sequenceReconstruction(int[] org, int[][] seqs) {
      Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
      Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
   	
      for (int num : org) {
         map.put(num, new HashSet<Integer>());
         indegree.put(num, 0);
      }
   
      int n = org.length;
      int count = 0;
      for (int[] seq : seqs) {
         count += seq.length;
         if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n))
            return false;
         for (int i = 1; i < seq.length; i++) {
            if (seq[i] <= 0 || seq[i] > n)
               return false;
            if (map.get(seq[i - 1]).add(seq[i]))
               indegree.put(seq[i], indegree.get(seq[i]) + 1);
         }
      }
   
      // case: [1], []
      if (count < n)
         return false;
   	
      Queue<Integer> q = new ArrayDeque<Integer>();
      for (int key : indegree.keySet()) 
         if (indegree.get(key) == 0)
            q.add(key);
   	
      int cnt = 0;
      while (q.size() == 1) {
         int ele = q.poll();
         for (int next : map.get(ele)) {
            indegree.put(next, indegree.get(next) - 1);
            if (indegree.get(next) == 0) q.add(next);
         }
         if (ele != org[cnt]) {
            return false;
         }
         cnt++;
      }
   	
      return cnt == org.length;
   }*/
   //Method 2: make sure that there is always only one item in the Queue.
   private static boolean sequenceReconstruction(int[] org, int[][] seqs){
      if(org == null || seqs == null) return false;
      int[]indegree = new int[org.length];
      for(int i = 0; i < seqs.length; i++){
         //if(seqs[i][1] >= indegree.length) return false;
         indegree[seqs[i][1]-1]++;
      }
      Queue<Integer> q = new LinkedList<>();
      for(int j = 0; j <org.length; j++) {
         if(indegree[j] == 0) {
            q.offer(j);
         }
      }
      int[] order = new int[org.length];
      int count = 0;
      while(!q.isEmpty()){
         if(q.size()>1) return false;
         int num = q.poll()+1;
         order[count] = num;
         count++;
         for(int h = 0; h < seqs.length; h++) {
            if (num == seqs[h][0]) {
               indegree[seqs[h][1]-1]--;
               if(indegree[seqs[h][1]-1] == 0){
                  q.offer(seqs[h][1]-1);
               }
            }
         }
      }
      for(int k = 0; k < org.length; k++) {
         if(order[k] != org[k]){
            return false;
         }
      }
      return true;
   }
}