import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StrangeCounter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int count = 3;
        int init = 3;
        for (int i = 0; i < t-1; i++){
            if (init == 1){
                init = 2*count;
                count = 2 * count;
            } else {
                init--;
            }
        }
        System.out.println(init);
    }
}