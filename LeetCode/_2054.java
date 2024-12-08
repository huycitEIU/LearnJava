
import java.util.Arrays;

public class _2054 {

    public static void main(String[] args) {
        int[][] events = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };
        Solution solution = new Solution();
        System.out.println(solution.maxTwoEvents(events));
    }

    static class Solution {

        public int maxTwoEvents(int[][] events) {
            int n = events.length;
            Arrays.sort(events, (a, b) -> a[0] - b[0]);
            int ans = 0;
            int[] suffix = new int[n];
            suffix[n - 1] = events[n - 1][2];
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = Math.max(events[i][2], suffix[i + 1]);
            }

            for (int i = 0; i < n; i++) {
                int left = i + 1, right = n - 1;
                int next = -1;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (events[i][1] < events[mid][0]) {
                        right = mid - 1;
                        next = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (next != -1) {
                    ans = Math.max(ans, events[i][2] + suffix[next]);
                }

                ans = Math.max(ans, events[i][2]);
            }
            return ans;
        }
    }
}
