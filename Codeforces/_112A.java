public class _112A {

    static java.util.Scanner sc = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(comapare(s1, s2));
    }

    static int comapare(String s1, String s2) {
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            int c1 = s1.charAt(i);
            if (c1 > 'Z') c1 -= 32;
            char c2 = s2.charAt(i);
            if (c2 > 'Z') c2 -= 32;
            if (c1 < c2) {
                return -1;
            } else if (c1 > c2) {
                return 1;
            }
        }
        return 0;
    }
}
