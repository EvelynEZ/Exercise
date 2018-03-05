import java.util.*;
import java.io.*;

public class BukcetWord{
    public static void main(String[] args){
     	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] bucket= new String[n];
        String target = sc.next();
        while(target.length() == 0) target = sc.next();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            while(s.length() == 0) s = sc.next();
        	   bucket[i] = s;
        }
        boolean[] used = new boolean[n];
        System.out.println(helper(bucket, used, target, 0));
                    
    }
 	private static boolean helper(String[] bucket, boolean[] used, String target, int index){
     	if(index == target.length()) return true;
      boolean res = false;
      char c = target.charAt(index);
        for(int i = 0; i < bucket.length; i++){
         	if(used[i]) continue;
            if(bucket[i].indexOf(c) != -1){
             	used[i] = true;
               res |= helper(bucket, used, target, index + 1);
                used[i] = false;
            }
        }
        return res;
    }
}