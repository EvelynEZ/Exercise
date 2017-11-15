import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedArray {

    static int solve(int[] a){
        int left = 0;
        int right = 0;
        for (int i = 0; i <= (a.length-1)/2; i++) {
            left += a[i];
        }
        for(int j = a.length/2; j <  a.length; j++ ){
            right +=a[j];
        }
        
        return  Math.abs(left - right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = solve(a);
        System.out.println(result);
    }
}