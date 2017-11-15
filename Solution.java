import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        for (int j = 0; j < size; j++){
            for (int h = 0; h < size; h++){
               matrix[j][h] = sc.nextInt();
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < size; i++){
            sum1 += matrix[i][i];
            sum2 += matrix[i][size-1-i];
        }
        System.out.println(Math.abs(sum1-sum2));
    }
}