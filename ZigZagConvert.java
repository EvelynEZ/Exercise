import java.io.*;
import java.util.*;


public class ZigZagConvert{
   public static void main(String[] args){
      System.out.println(convert("paypalishiring", 1));
   }
  
   public static String convert(String s, int nRows) {
        
        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i = 0; i < nRows; i++){
            sb[i] = new StringBuffer();
        }
        int index = 0;
        int len = s.length();
        while(index < len){
            for(int j = 0; j <nRows && index < len; j++){
                sb[j].append(s.charAt(index++));
            }
            for(int h = nRows - 2; h > 0 && index < len; h--){
                sb[h].append(s.charAt(index++));
            }
        }
        for(int k = 1; k < nRows; k++){
            sb[0].append(sb[k]);
        }
        return sb[0].toString();
      
   }
}