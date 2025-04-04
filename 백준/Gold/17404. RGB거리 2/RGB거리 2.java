import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int N;
    static int[][] cost, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // R
            cost[i][1] = Integer.parseInt(st.nextToken()); // G
            cost[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        int answer = INF;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            dp = new int[N][3];

            // 첫 번째 집은 선택한 색만 그대로, 나머지는 큰 값으로 초기화
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) dp[0][i] = cost[0][i];
                else dp[0][i] = INF;
            }

            // DP 점화식
            for (int i = 1; i < N; i++) {
                dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            // 마지막 집의 색이 첫 집과 다를 때만 정답 후보로 고려
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) continue;
                answer = Math.min(answer, dp[N - 1][lastColor]);
            }
        }

        System.out.println(answer);
    }
}
