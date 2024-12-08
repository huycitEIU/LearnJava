
import java.util.Scanner;

public class _1A {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long n, m, a;
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        n = n / a + ((n % a > 0) ? 1 : 0);
        m = m / a + ((m % a > 0) ? 1 : 0);
        System.out.println(n * m);
    }
}
