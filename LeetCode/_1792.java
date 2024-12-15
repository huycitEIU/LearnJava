import java.util.PriorityQueue;

public class _1792 {
    public static void main(String[] args) {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        Solution solution = new Solution();
        System.out.println(solution.maxAverageRatio(classes, extraStudents));
    }
    static class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<double[]> ratios = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
            for (int[] clazz : classes) {
                ratios.add(new double[]{calculateRatio(clazz[0], clazz[1]), (double) clazz[0], (double) clazz[1]});
            }

            while (extraStudents-- > 0) {
                double[] ratio = ratios.poll();
                ratio[1]++;
                ratio[2]++;
                ratios.add(new double[]{calculateRatio(ratio[1], ratio[2]), ratio[1], ratio[2]});
            }
            double ans = 0;
            for (double[] ratio : ratios) {
                ans += ratio[1] / ratio[2];
            }
            return ans / classes.length;
        }
        static double calculateRatio(double pass, double total) {
            return (double) (pass + 1) / (total + 1) - (double) pass / total;
        }
    }
}
