import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Chocolate {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int s = in.nextInt();
      List<Integer> list = new ArrayList<>();
      for(int i = 0 ; i < n; i++){
         list.add(i);
      }
      for(int a0 = 0; a0 < s; a0++){
         int l = in.nextInt();
         int r = in.nextInt();
         int sum = 0;
         if(list.indexOf(l) > 0){
            int numLeft = list.get(list.indexOf(l)-1);
            sum += numLeft;
            list.remove(list.indexOf(numLeft));
         }
         if(list.indexOf(r) < list.size() - 1){
            int numRight = list.get(list.indexOf(r)+1);
            sum += numRight;
            list.remove(list.indexOf(numRight));
         }
         for(int x = l; x <= r; x++){
            sum += x;
            list.remove(list.indexOf(x));
         }
         
         
         System.out.println(sum);
      }
      in.close();
   }
}