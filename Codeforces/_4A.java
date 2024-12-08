import java.util.Scanner;

public class _4A {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        int w = sc.nextInt();
        System.out.println(check(w));

    }
    public static String check(int w) {
        for (int i = 2; i < w; i += 2) {
            if ((w - i) % 2 == 0) {
                return "YES";
            }
        }
        return "NO";
    }
}





