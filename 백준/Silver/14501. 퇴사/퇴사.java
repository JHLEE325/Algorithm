import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = n; i >= 1; i--) {
            int nextDay = i + t[i];

            if (nextDay <= n + 1) {
                dp[i] = Math.max(p[i] + dp[nextDay], dp[i + 1]);
            } 
            else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
        sc.close();
    }
}