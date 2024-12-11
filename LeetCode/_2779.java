import java.util.Arrays;

public class _2779 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.maximumBeauty(nums, k));
    }

    static class Solution {
        public int maximumBeauty(int[] nums, int k) {
            int ans = 0;
            Arrays.sort(nums);
            int _2k = 2 * k;
            for (int i = 0; i < nums.length; i++) {
                int low = i, high = nums.length - 1;
                while (low <= high) {
                    int mid = (low + high) >> 1;
                    int sum = nums[mid] - nums[i];
                    if (sum > _2k) {
                        high = mid - 1;
                    } else {
                        ans = Math.max(ans, mid - i + 1);
                        low = mid + 1;
                    }
                }

            }
            return ans;
        }
    }
}