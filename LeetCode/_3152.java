
import java.util.Arrays;

public class _3152 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 6};
        int[][] queries = {{0, 2}, {2, 3}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.isArraySpecial(nums, queries)));
    }
    static class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            int n = nums.length;
            int m = queries.length;
            boolean[] res = new boolean[m];
            int[] subArray = new int[n];
            int index = 0;
            int pre = nums[0] + 1;
            int i = 0;
            for (i = 0; i < n; i++) {
                if (nums[i] % 2 != pre % 2) {
                    pre = nums[i];
                    continue;
                }
                subArray[index] = i - 1;
                index = i;
                pre = nums[i];
            }
            subArray[index++] = i - 1;
            for (i = 1; i < n; i++) {
                if (subArray[i] == 0) {
                    subArray[i] = subArray[i - 1];
                }
            }
            for (i = 0; i < queries.length; i++) {
                res[i] = check(subArray, queries[i][0], queries[i][1]);
            }
            return res;
        }

        private boolean check(int[] subArray, int start, int end) {
            if (start == end) {
                return true;
            }
            return end <= subArray[start];
        }
    
    }

}