public class _2593 {
    public static void main(String[] args) {
        int[] nums = {29,20,36,39,50,42,46,34,47};
        Solution solution = new Solution();
        System.out.println(solution.findScore(nums));
    }

    static class Solution {
        public long findScore(int[] nums) {
            long res = 0;
            SegmentTree st = new SegmentTree(nums);
            while (true) {
                Pair pair = st.query(0, nums.length - 1);
                if (pair == null) break;
                res += pair.value;
                st.update(pair.index);
                if (pair.index + 1 < nums.length) {
                    st.marked[pair.index + 1] = true;
                    st.update(pair.index + 1);
                }
                if (pair.index - 1 >= 0) {
                    st.marked[pair.index - 1] = true;
                    st.update(pair.index - 1);
                }
            }
            return res;
        }
    }
    static class Pair {
        int index;
        int value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    // Segment Tree
    static class SegmentTree {
        final private Pair[] tree;
        final private int n;
        final private boolean[] marked;
        // Constructor to initialize the segment tree
        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new Pair[4 * n]; // Allocating enough space for the tree
            marked = new boolean[n];
            build(nums, 0, 0, n - 1); // Build tree
        }

        // Build the segment tree
        private void build(int[] nums, int node, int start, int end) {
            if (start == end) {
                // Leaf node: store the array value
                tree[node] = new Pair(start, nums[start]);
            } else {
                int mid = start + (end - start) / 2;
                int leftChild = 2 * node + 1;
                int rightChild = 2 * node + 2;

                // Recursively build left and right subtrees
                build(nums, leftChild, start, mid);
                build(nums, rightChild, mid + 1, end);

                // Combine the results of the left and right child
                Pair pair;
                if (tree[leftChild].value > tree[rightChild].value) {
                    pair = tree[rightChild];
                } else {
                    pair = tree[leftChild];
                }

                tree[node] = pair;
            }
        }

        // Range sum query
        public Pair query(int L, int R) {
            return queryHelper(0, 0, n - 1, L, R);
        }

        private Pair queryHelper(int node, int start, int end, int L, int R) {
            // If the current segment is completely outside the query range
            if (start > R || end < L) {
                return null; // Return a neutral value for sum
            }

            // If the current segment is completely inside the query range
            if (start >= L && end <= R) {
                if (marked[tree[node].index]) return null;
                marked[tree[node].index] = true;
                return tree[node];
            }

            // Partial overlap: compute results from both sides
            int mid = start + (end - start) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            Pair leftMin = queryHelper(leftChild, start, mid, L, R);
            Pair rightMin = queryHelper(rightChild, mid + 1, end, L, R);

            if (leftMin != null && rightMin != null) {
                if (marked[leftMin.index] && marked[rightMin.index])
                    return (leftMin.value > rightMin.value) ? rightMin : leftMin;
                if (marked[leftMin.index]) return leftMin;
                if (marked[rightMin.index]) return rightMin;
            }
            if (leftMin != null && !marked[leftMin.index]) return leftMin;
            if (rightMin != null && !marked[rightMin.index]) return rightMin;

            return null;
        }

        // Point update: update a value in the array
        public void update(int idx) {
            updateHelper(0, 0, n - 1, idx);
        }

        private void updateHelper(int node, int start, int end, int idx) {
            if (start == end) return;
            int mid = start + (end - start) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            // Recurse to the correct child
            if (idx <= mid) {
                updateHelper(leftChild, start, mid, idx);
            } else {
                updateHelper(rightChild, mid + 1, end, idx);
            }

            // Update the current node after updating the child
            if (!marked[tree[leftChild].index] && !marked[tree[rightChild].index]) {
                tree[node] = (tree[leftChild].value > tree[rightChild].value) ? tree[rightChild] : tree[leftChild];
            } else if (marked[tree[leftChild].index]) {
                tree[node] = tree[rightChild];
            } else if (marked[tree[rightChild].index]) {
                tree[node] = tree[leftChild];
            }

        }
    }
}