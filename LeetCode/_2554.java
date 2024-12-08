
public class _2554 {

    public static void main(String[] args) {
        int[] banned = {1, 1, 2};
        int n = 7;
        int maxSum = 5;
        Solution solution = new Solution();
        System.out.println(solution.maxCount(banned, n, maxSum));
    }
    static class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            int ans = 0;
            boolean[] numbers = new boolean[10007];
            for (int ban : banned) {
                numbers[ban] = true;
            }
            for (int i = 1, sum = 0; i <= n && sum + i <= maxSum; i++) {
                if (!numbers[i]) {
                    sum += i;
                    ans++;
                }
            }
            return ans;
        }
    }
}


