
import java.util.Arrays;

public class _3152 {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int[][] queries = {{0, 1}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.isArraySpecial(nums, queries)));
    }
    static class Solution { 
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            int[] prefix = new int[nums.length];
            boolean[] res = new boolean[queries.length];
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = prefix[i - 1] + 1 - Math.abs((nums[i] - nums[i - 1])) % 2;
            }
            System.out.println(Arrays.toString(prefix));
            for (int i = 0; i < queries.length; i++) {
                res[i] = prefix[queries[i][1]] - prefix[queries[i][0]] == 0;
            }
            return res;
        }
    }

}