import java.util.Scanner;

public class _71A {
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        int t = sc.nextInt();
        while (t-- >= 0) {
            String s = sc.nextLine();
            System.out.println(solve(s));    
        }
    }
    
    static String solve(String s) {
        if (s.length() > 10) {
            String res = "";
            res += s.charAt(0);
            res += s.length() - 2 + "";
            res += s.charAt(s.length() - 1);
            return res;
        } else {
            return s;
        }
 
    }  
}

