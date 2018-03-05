import java.util.*;
import java.io.*;

public class Bomb{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int row = sc.nextInt();
      int col = sc.nextInt();
      int Ax = -1, Ay = -1;
      int Bx = -1, By = -1;
      char[][] area = new char[row][col];
      for(int i = 0; i < row; i++){
         String r = sc.next();
         while(r.length() == 0)  r = sc.next();
         for(int j = 0; j < col; j++){
            area[i][j] = r.charAt(j);
            if(r.charAt(j) == 'A'){
               Ax = i;
               Ay = j;
            } else if(r.charAt(j) == 'B'){
               Bx = i;
               By = j;
            }
         }
      }
      boolean[][] used = new boolean[row][col];
      System.out.println(validArea(area, used,  Ax,Ay, Bx, By));
   }
   //# safe * danger
   public static boolean validArea(char[][] area, boolean[][] used, int Ax,int Ay, int Bx,int By){
      int row = area.length;
      int col = area[0].length;
      if(Ax == Bx && Ay == By) 
         return true;
      boolean res = false;
      
      //up
      if(Ay > 1 && !used[Ax][Ay-1] && area[Ax][Ay-1] != '*'){
         boolean validMove = true;
         int start = (Ax > 1? Ax-1:0);
         int end = (Ax+1 < col? Ax+1:col - 1);
         for(int i = start; i <= end ; i++){
            if(area[i][Ay-1] == '*') {
               validMove = false; 
               break;
            }
         }
         if(validMove) {
            used[Ax][Ay-1] = true;
            res |= validArea(area, used, Ax, Ay-1, Bx, By);
         }
      }
      if(res) 
         return true;
      //left
      if(Ax > 1 && !used[Ax-1][Ay] && area[Ax-1][Ay] != '*'){
         boolean validMove = true;
         int start = Ay > 1? Ay-1:0;
         int end = Ay+1 < row? Ay+1:row - 1;
         for(int i = start; i <= end; i++){
            if(area[Ax-1][i] == '*') {
               validMove = false; 
               break;
            }
         }
         if(validMove) {
            used[Ax-1][Ay] = true;
            res |= validArea(area, used, Ax-1, Ay, Bx, By);
         }
      }
      if(res) 
         return true;
      //down
      if(Ay + 1 < row && !used[Ax][Ay+1] && area[Ax][Ay+1] != '*'){
         boolean validMove = true;
         int start = Ax > 1? Ax-1:0;
         int end = Ax+1 < col? Ax+1:col - 1;
         for(int i = start; i <= end; i++){
            if(area[i][Ay+1] == '*') {
               validMove = false; 
               break;
            }
         }
         if(validMove) {
            used[Ax][Ay+1] = true;
            res |= validArea(area, used, Ax, Ay+1, Bx, By);
         }
      }
      if(res) 
         return true;
      //right
      if(Ax+1 < col  && !used[Ax+1][Ay] && area[Ax+1][Ay] != '*'){
         boolean validMove = true;
         int start = Ay > 1? Ay-1:0;
         int end = Ay+1 < row? Ay+1:row - 1;
         for(int i = start; i <= end; i++){
            if(area[Ax+1][i] == '*') {
               validMove = false; 
               break;
            }
         }
         if(validMove) {
            used[Ax+1][Ay] = true;
            res |= validArea(area, used, Ax+1, Ay, Bx, By);
         }
      }
      if(res) 
         return true;
      //right down
      if(Ax+1 < col && Ay+1 < row && !used[Ax+1][Ay+1]  && area[Ax+1][Ay+1] != '*'){
         if(area[Ax][Ay+1] != '*' || area[Ax+1][Ay] != '*') {
            used[Ax+1][Ay+1] = true;
            res |= validArea(area, used, Ax+1, Ay+1, Bx, By);
         }
      }
      if(res) 
         return true;
      //right up
      if(Ax+1 < col && Ay-1 > 0 && !used[Ax+1][Ay-1] && area[Ax+1][Ay-1] != '*'){
         if(area[Ax][Ay-1] != '*' || area[Ax+1][Ay] != '*') {
            used[Ax+1][Ay-1] = true;
            res |= validArea(area, used, Ax+1, Ay-1, Bx, By);
         }
      }
      if(res) 
         return true;
      //left down
      if(Ax-1 > 0 && Ay+1 < row && !used[Ax-1][Ay+1] && area[Ax-1][Ay+1] != '*'){
         if(area[Ax-1][Ay] != '*' || area[Ax][Ay+1] != '*') {
            used[Ax-1][Ay+1] = true;
            res |= validArea(area, used, Ax-1, Ay+1, Bx, By);
         }
      }
      if(res) 
         return true;
      //left up
      if(Ax-1 > 0 && Ay-1 > 0 && !used[Ax-1][Ay-1] && area[Ax-1][Ay-1] != '*'){
         if(area[Ax][Ay-1] != '*' || area[Ax-1][Ay] != '*') {
            used[Ax-1][Ay-1] = true;
            res |= validArea(area, used, Ax-1, Ay-1, Bx, By);
         }
      }
      return res;
   
   }
}