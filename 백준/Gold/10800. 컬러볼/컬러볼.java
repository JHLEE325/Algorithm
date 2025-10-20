import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] balls = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            balls[i][0] = i;
            balls[i][1] = Integer.parseInt(st.nextToken());
            balls[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(balls, Comparator.comparing(ball -> ball[2]));

        int[] res = new int[n];
        int sum = 0;
        int[] color = new int[n + 1];
        int cur = 0;

        for (int i = 0; i < n; i++) {
            int idx = balls[i][0];
            int c = balls[i][1];
            int w = balls[i][2];

            while (balls[cur][2] < w) {
                sum += balls[cur][2];
                color[balls[cur][1]] += balls[cur][2];
                
                cur++;
            }

            res[idx] = sum - color[c];
        }

        StringBuilder sb = new StringBuilder();

        for (int r : res) {
            sb.append(r).append("\n");
        }
        System.out.println(sb.toString());

    }
}
