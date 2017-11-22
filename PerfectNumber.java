import java.io.*;
import java.util.*;
public class PerfectNumber {
   public static void main(String [] args) {
      System.out.println(checkPerfectNumber(25));
   }
   
   public static boolean checkPerfectNumber(int num) {
      if(num == 0) 
         return true;
      int sum = 1;
      int i = 2;
      while(i*i < num){
         if(num%i == 0){
            sum += i;
            sum += num/i;
         }
         i++;
      }
      if(i*i == num) sum += i;
      if(sum == num) 
         return true;
      return false;
   }
   /*public static boolean checkPerfectNumber(int num) {
      List<Integer> divisor = getDivisor(num);
      int sum = 0;
      for(int n :  divisor){
         sum += n;
         if(sum > num) 
            return false;
      }
      if(sum == num) 
         return true;
      return false;
   }
    
   public static List<Integer> getDivisor(int num){
      List<Integer> result = new ArrayList<>();
      for(int i = 1; i <= num/2; i++){
         if(num%i == 0){
            result.add(i);
         }
      }
      return result;
   }*/
  
}