/*Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
*/
import java.io.*;
import java.util.*;
public class MinDiffTime {
   public static void main(String[] args){
      List<String> time = new ArrayList<>();
      time.add("23:59");
      time.add("00:00");
      System.out.println(findMinDifference(time));
   }
   public int findMinDifference(List<String> timePoints) {
        Set<Integer> timeStamp = new HashSet<>();
        for(String time: timePoints) {
            String[] t = time.split(":");
            int minite = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if(!timeStamp.add(minite)) return 0;
        }
        List<Integer> list = new ArrayList<>();
        for(int time : timeStamp) list.add(time);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        int pre = 0, cur = 0, first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for(int time : list){
            first = Math.min(first, time);
            last = Math.max(last, time);
            if(pre == 0){
                pre = time;
            } else {
                cur = time;
                min = Math.min(cur - pre, min);
                pre = cur;
            }
        }
        
        min = Math.min(min, 24*60 - last + first);
       return min;
    }
   /*
   //Bucket
   public static int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        
        return min;
    }*/
    
}