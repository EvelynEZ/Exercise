import java.io.*;
import java.util.*;

public class RomtoNum {

    public static void main(String[] args) {
        System.out.println(romanToInt("MMMCMXCIX"));
    }
    public static int romanToInt(String s) {
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                num[i] = 1;
            } else if (s.charAt(i) == 'V'){
                num[i] = 5;
            } else if (s.charAt(i) == 'X'){
                num[i] = 10;
            } else if (s.charAt(i) == 'L'){
                num[i] = 50;
            } else if (s.charAt(i) == 'C'){
                num[i] = 100;
            } else if (s.charAt(i) == 'D'){
                num[i] = 500;
            } else if (s.charAt(i) == 'M'){
                num[i] = 1000;
            } else {
                num[i] = 0;
            }
        }
        int result = 0;
        for (int j = 0; j < s.length() - 1; j++){
            if (num[j] < num[j+1]){
                result -= num[j];
            } else{
                result += num[j];
            }
        }
        result+=num[s.length()-1];
        return result;
    }
    
}