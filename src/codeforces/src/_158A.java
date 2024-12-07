public class _158A {
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        int n, k;
        int ans = 0;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] >= arr[k - 1]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
