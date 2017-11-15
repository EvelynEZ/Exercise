import java.io.*;
import java.util.*;
public class LexicoString{
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      String[] z = new String[n];
      for(int z_i = 0; z_i < n; z_i++){
         z[z_i] = in.next();
      }
      int q = in.nextInt();
      for(int a0 = 0; a0 < q; a0++){
         int l = in.nextInt();
         int r = in.nextInt();
         String s = in.next();
         int sum = 0;
         for(int i = l; i < Math.min(z.length+1, r+1); i++){
            if(z[i-1].compareTo(s) <= 0) sum++;
         }
         System.out.println(sum);
      }
      in.close();
   }
         
}