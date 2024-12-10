import java.util.HashMap;

public class _2981 {
    public static void main(String[] args) {
        String s = "fafff";
        Solution solution = new Solution();
        System.out.println(solution.maximumLength(s));
    }

    static class Solution {
        public int maximumLength(String s) {
            int ans = -1;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        sb.append(s.charAt(j));
                        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                    } else {
                        break;
                    }
                }

            }
            System.out.println(map);
            for (String k : map.keySet()) {
                ans = Math.max(ans, map.get(k) > 2 ? k.length() : -1);
            }
            return ans;
        }
    }
}
