import java.util.PriorityQueue;

public class _2558 {
    public static void main(String[] args) {
        int[] gifts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 4;
        Solution solution = new Solution();
        System.out.println(solution.pickGifts(gifts, k));
    }

    static class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int gift : gifts) {
                pq.add(gift);
            }
            long ans = 0;
            while (k-- > 0) {
                if (pq.isEmpty()) break;
                int gift = pq.poll();
                int reduceGift = (int) Math.sqrt(gift);
                if (reduceGift == gift) break;
                pq.add(reduceGift);
            }

            for (int gift : pq) {
                ans += gift;
            }
            return ans;
        }
    }
}
