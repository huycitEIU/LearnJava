public class _2825 {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ad";
        Solution solution = new Solution();
        System.out.println(solution.canMakeSubsequence(str1, str2));
    }
    static class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            for (int i = 0, j = 0, len = str1.length(); i < len; i++) {
                if (compare(str1.charAt(i), str2.charAt(j)))
                    j++;
    
                if (j == str2.length())
                    return true;
            }
            return false;
        }
    
        private boolean compare(char a, char b) {
            return a == b || (a + 1 == b || (a == 'z' && b == 'a'));
        }
    }
}

