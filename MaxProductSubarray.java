public class MaxProductSubarray {
   public static void main(String[] args) {
      int[] A = {2, 3, -2, 2, 4};
      System.out.println(maxProduct(A));
   
   }
   
    public static int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            int m = Math.max(max * A[i], min * A[i]);
            int n = Math.min(temp * A[i], min * A[i]);
            max = Math.max(m, A[i]);
            min = Math.min(n, A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}