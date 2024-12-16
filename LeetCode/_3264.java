import java.util.Comparator;
import java.util.PriorityQueue;

public class _3264 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        Solution solution = new Solution();
        int[] out = solution.getFinalState(nums, k, multiplier);
        for (int j : out) {
            System.out.print(j + " ");
        }
    }

    static class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            int n = nums.length;
            PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
            for (int i = 0; i < n; i++) {
                pq.offer(new Pair(nums[i], i));
            }
            while (!pq.isEmpty() && k-- > 0) {
                Pair p = pq.poll();
                p.value *= multiplier;
                pq.offer(new Pair(p.value, p.index));
                nums[p.index] = p.value;
            }
            return nums;
        }
        private static class Pair {
            int value;
            int index;
            public Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }

        Comparator<Pair> comparator = (o1, o2) -> {
            if (o1.value != o2.value) {
                return o1.value - o2.value;
            } else {
                return o1.index - o2.index;
            }
        };
    }

}
