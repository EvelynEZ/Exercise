import java.io.*;
import java.util.*;
public class PascallTriangleII{
   public static void main(String [] args){
      System.out.println(getRow(5).toString());
   }
   public static List<Integer> getRow(int rowIndex) {
      List<Integer> res = new ArrayList<>();
      if(rowIndex < 0) 
         return res;
      List<Integer> pre = new ArrayList<>();
      pre.add(1);
      if(rowIndex < 1) 
         return pre;
      for(int row = 1; row <= rowIndex; row++){
         res.clear();
         res.add(1);
         for(int col = 1; col < row; col++){
            res.add(pre.get(col - 1) + pre.get(col));
         }
         res.add(1);
         pre = new ArrayList();
         pre.addAll(res);
      }
      return res;
   }
}