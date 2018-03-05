import java.io.*;
import java.util.*;
public class MultiplicationTable{
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int m = scan.nextInt();
      int n = scan.nextInt();
      int k =scan.nextInt();
      System.out.println(getNum(n, m, k));
   }
	
   private static int getNum(int n, int m, int k){
      int[] bucket = new int[n * m];
      int index = 0;
      for(int i = 1; i <= n; i ++){
         for(int j = 1; j<= m; j++){
            bucket[index++] = i * j;
         }
      }
      Arrays.sort(bucket);

      return bucket[k-1];
   }

}