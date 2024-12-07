public class _1760 {
    
    
    public static void main(String[] args) {
        int[] nums = {9};
        int maxOperations = 2; 
        Solution solution = new Solution();  
        System.out.println(solution.minimumSize(nums, maxOperations));
    }

    static class Solution {
        /**
         * @param nums  the array of ball bags
         * @param maxOperations the number of operations that can be performed
         * @return the minimum size of the largest bag
         */
        public int minimumSize(int[] nums, int maxOperations) {
            int low = 1, high = 1000000000;
            while (low < high) {
                int mid = (low + high) >> 1;
                if (check(nums, mid, maxOperations)) {
                    high = mid;
                } else { 
                    low = mid + 1;
                }
            }
            return low;
        }
        /**
         * @param nums  the array of ball bags
         * @param mid the maximum size of the subarray
         * @param maxOperations the number of operations that can be performed
         * @return true if the number of operations is less than or equal to maxOperations
         */
        private boolean check(int[] nums, int mid, int maxOperations) {
            int count = 0;
            for (int num: nums) {
                if (num > mid) {
                    count += (num - 1) / mid;
                }
            }
            return count <= maxOperations;
        }
    }
}
