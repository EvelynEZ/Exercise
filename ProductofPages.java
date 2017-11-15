import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProductofPages {

   static int productOfPages(int a, int b, int c, int d, int p, int q) {
      // Return the product of the page counts of the missing books
      List<Integer> list = new ArrayList<>();
      list.add(a);
      list.add(b);
      list.add(c);
      list.add(d);
      list.remove(list.indexOf(p));
      list.remove(list.indexOf(q));
      int r = list.remove(0);
      int t = list.remove(0);
      return r*t;
   }

   public static void main(String[] args) {
      System.out.println(productOfPages(20, 10, 40, 30 ,10, 30));
          
   }
}