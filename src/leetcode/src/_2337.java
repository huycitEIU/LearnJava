public class _2337 {
    public static void main(String[] args) {
        String str1 = "_L__R__R_";
        String str2 = "L______RR";
        Solution solution = new Solution();
        System.out.println(solution.canChange(str1, str2));
    }
    static class Solution {
        public boolean canChange(String start, String target) {
            int s = 0;
            int t = 0;
            int len = start.length();
            while (s <= len && t <= len) {
                
                while (s < len && start.charAt(s) == '_') s++;
                while (t < len && target.charAt(t) == '_') t++;
                
                if (s == len || t == len) return s == len && t == len;
    
                if (start.charAt(s) != target.charAt(t)) return false;
                
                if (target.charAt(t) == 'L' && s < t) return false;
                if (target.charAt(t) == 'R' && s > t) return false;
                s++;
                t++;
            }      
            return true;
        }
    }
}