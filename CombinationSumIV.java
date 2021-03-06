public class CombinationSumIV{
   public static void main(String [] args) {
      int[] nums = {1, 2, 3};
      System.out.println(combinationSum4(nums, 4));
   }
   
   
   
   public static int combinationSum4(int[] nums, int target) {
      int[] comb = new int[target + 1];
      comb[0] = 1;
      for (int i = 1; i < comb.length; i++) {
         for (int j = 0; j < nums.length; j++) {
            if (i - Math.abs(nums[j]) >= 0) {
               comb[i] += comb[i - nums[j]];
            }
         }
      }
      return comb[target];
   }

}