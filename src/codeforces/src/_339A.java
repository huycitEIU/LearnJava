public class _339A {

    static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.nextLine();
        int[] count = new int[4];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '+') {
                count[s.charAt(i) - '0']++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            while (count[i]-- > 0) {
                sb.append((char) (i + '0'));
                sb.append('+');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
