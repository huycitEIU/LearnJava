import java.util.Scanner;

public class _231A {
	static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int ans = 0;
        int sure = 0; 
        int n = sc.nextInt();
        while (n-- > 0) {
            sure = sc.nextInt() + sc.nextInt() + sc.nextInt();
            if (sure > 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
