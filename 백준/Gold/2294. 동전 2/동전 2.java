import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int c : coin) {
            for (int m = c; m <= k; m++) {
                dp[m] = Math.min(dp[m], dp[m - c] + 1);
            }
        }

        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}