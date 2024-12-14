import java.util.ArrayDeque;

public class _2762 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 4};
        Solution solution = new Solution();
        System.out.println(solution.continuousSubarrays(nums));
    }

    static class Solution {
        public int continuousSubarrays(int[] nums) {
            int ans = 0;
            Storage storage = new Storage(nums.length);
            for (int num : nums) {
                storage.push(num);
                ans += storage.getSize();
                while (storage.getMax() - storage.getMin() > 2) {
                    ans--;
                    storage.pop();
                }

            }
            return ans;
        }
        private static class Storage {
            final private ArrayDeque<Integer> deque;
            final private ArrayDeque<Integer> minDeque;
            final private ArrayDeque<Integer> maxDeque;

            public Storage (int size) {
                deque = new ArrayDeque<>(size);
                minDeque = new ArrayDeque<>(size);
                maxDeque = new ArrayDeque<>(size);
            }

            public int getSize() {
                return deque.size();
            }

            public void push(int val) {
                while (!minDeque.isEmpty() && val < minDeque.peekLast()) {
                    minDeque.removeLast();
                }
                minDeque.addLast(val);
                while (!maxDeque.isEmpty() && val > maxDeque.peekLast()) {
                    maxDeque.removeLast();
                }
                maxDeque.addLast(val);
                deque.addLast(val);
            }

            public int getMin() {
                return minDeque.peekFirst();
            }

            public int getMax() {
                return maxDeque.peekFirst();
            }

            public void pop() {
                if (deque.peekFirst().equals(minDeque.peekFirst())) {
                    minDeque.removeFirst();
                }
                if (deque.peekFirst().equals(maxDeque.peekFirst())) {
                    maxDeque.removeFirst();
                }
                deque.remove();
            }

        }
    }

}
