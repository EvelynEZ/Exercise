/*
n objetcs, k different colors(numbered from 1 to k).
sort so that the objects of the same color are adjacent and 
of the order 1, 2, ..., k.
eg. colors = [3, 2, 2, 1, 4], k = 4
sort in place: [1, 2, 2, 3, 4]

*/
import java.io.*;
import java.util.*;
public class SortColorsII{
   public static void main(String[] args){
      int[] colors = {3, 2, 2, 1, 4};
      sortColor(colors);
      for(int color: colors){
         System.out.println(color);
      }
   } 
   /*//Space: O(N), time: O(N).
   public static void sortColor (int[] a){
      int[] bucket = new int[a.length+1];
      for(int color : a){
         bucket[color]++;
      }
      int Aindex = 0;
      int Bindex = 0;
      while(Bindex < bucket.length && Aindex < a.length){
         while(bucket[Bindex] > 0) {
            a[Aindex++] = Bindex;
            bucket[Bindex]--;
         }
         Bindex++;
      }
   }*/
   
   //Time: O(nlogk) Space:O(1);
   public static void sortColor(int[]a){
      int len = a.length;
      rainbowSort(a, 0, len - 1, 1, len);
   }
   
   public static void rainbowSort(int[]a, int left, int right, 
                        int colorFrom, int colorTo){
      //base case
      if(left > right || colorFrom == colorTo) return;
      int l = left, r = right;
      int colorMid = colorFrom + (colorTo - colorFrom)/2;
      while(l <= r) {
         //find larger than mid color.
         while(l <= r && a[l] < colorMid) l++;
         //find smaller than mid color. 
         while(l <= r && a[r] >= colorMid) r--;
         //swap the two
         if(l < r){
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
         }
      }
      //two parts 
      //left: color:colorFrom to colorMid
      //right: color: colorMid+1 to colorTo
      rainbowSort(a, left, r, colorFrom, colorMid);
      rainbowSort(a, l, right, colorMid+1, colorTo);
                        
                        
   }
}