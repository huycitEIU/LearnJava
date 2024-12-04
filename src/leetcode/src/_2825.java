public class _2825 {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ad";
        Solution solution = new Solution();
        System.out.println(solution.canMakeSubsequence(str1, str2));
    }
}

class Solution {
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
        if (a == b)
            return true;
        a += 1;
        if (a > 'z')
            a = 'a';
        if (a == b)
            return true;
        return false;
    }
}
