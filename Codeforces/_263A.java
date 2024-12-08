public class _263A {

    static java.util.Scanner sc = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (sc.nextInt() == 1) {
                    System.out.println(Math.abs(i - 3) + Math.abs(j - 3));
                    return;
                }
            }
        }
    }
}
