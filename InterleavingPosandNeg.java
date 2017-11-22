import java.io.*;
import java.util.*;
public class InterleavingPosandNeg{
   public static void main(String[] args) {
      int[] nums = {26,-31,10,-29,17,18,-24,-10};
      rerange(nums);
      for(int num : nums) {
         System.out.print(num + " ");
      }
   }
  public static void rerange(int[] A) {
        int cntPos = 0;
        for (int i : A) {
            if (i > 0) cntPos++;
        }

        if (cntPos > A.length - cntPos) {
            // even: pos, odd: neg
            int i = 0, j = 1;
            while (i < A.length && j < A.length) {
                while (A[i] > 0 && i + 2 < A.length) i += 2;
                while (A[j] < 0 && j + 2 < A.length) j += 2;
                if (A[i] < 0 && A[j] > 0) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
                i += 2;
                j += 2;
            }
        } else {
            // even: neg, odd: pos
            int i = 0, j = 1;
            while (i < A.length && j < A.length) {
                while (A[i] < 0 && i + 2 < A.length) i += 2;
                while (A[j] > 0 && j + 2 < A.length) j += 2;
                if (A[i] > 0 && A[j] < 0) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
                i += 2;
                j += 2;
            }
        }
    }
   
   /*
   //Time Limit Exceeds O(n^2)
   public static void rerange(int[] A) {
      if(A.length < 1) 
         return;
      int cur = 0, next = 0;
      boolean pos = A[0] > 0?true:false; // first number should be positive
      while(pos?A[cur]>=0:A[cur]<0){
         cur++;
         next++;
         pos = !pos;
      }
      while(cur < A.length - 1) {
         while(cur < A.length && (pos?A[cur]>=0 :A[cur]<0)){
            cur++;
            pos = !pos;
         }
         next = cur+1;
         while(next < A.length && (pos?A[next] < 0:A[next] >= 0)) next++;
         if(cur < A.length){
            int tmp = A[cur];
            A[cur++] = A[next];
            A[next] = tmp;
            pos = !pos;
         }
      }
        
   }*/
   
}