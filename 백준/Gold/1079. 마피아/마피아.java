import java.io.*;
import java.util.*;

public class Main {

    static int n, e;
    static int[] guilty;
    static int[][] response;
    static boolean[] killed;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        guilty = new int[n];
        response = new int[n][n];
        killed = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            guilty[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                response[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        e = Integer.parseInt(br.readLine());

        dfs(n, 0);
        System.out.println(ans);
    }

    static void dfs(int h, int night) {
        if (killed[e]) {
            ans = Math.max(ans, night);
            return;
        }

        if (h % 2 == 1) {
            int m_guilty = -1;
            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (!killed[i] && guilty[i] > m_guilty) {
                    m_guilty = guilty[i];
                    idx = i;
                }
            }

            killed[idx] = true;
            dfs(h - 1, night);
            killed[idx] = false;
        } else {
            for (int i = 0; i < n; i++) {
                if (i == e || killed[i]) continue;

                killed[i] = true;
                for (int j = 0; j < n; j++) {
                    guilty[j] += response[i][j];
                }

                dfs(h - 1, night + 1);

                for (int j = 0; j < n; j++) {
                    guilty[j] -= response[i][j];
                }
                killed[i] = false;
            }
        }
    }
}

