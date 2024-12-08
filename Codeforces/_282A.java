import java.util.Scanner;

public class _282A{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		int n = sc.nextInt();	
		int ans = 0;
		String op = sc.nextLine();
		while (n-- > 0) {
			op = sc.nextLine();
			if (op.charAt(0) == '+' || op.charAt(2) == '+') {
				ans++;
			} else {
				ans--;
			}
        }
        System.out.println(ans);
    }
}
