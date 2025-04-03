import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n, k, res, mh;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            visited = new boolean[n][n];
            mh = 0;
            res = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    mh = Math.max(mh, map[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == mh) {
                        visited[i][j] = true;
                        dfs(i, j, 1, false);
                        visited[i][j] = false;
                    }
                }
            }

            sb.append("#" + t + " " + res + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int y, int x, int len, boolean cut) {
        res = Math.max(res, len);

        for (int d = 0; d < 4; d++) {
            int dy = y + dir[d][0];
            int dx = x + dir[d][1];

            if (dy < 0 || dx < 0 || dy >= n || dx >= n || visited[dy][dx]) continue;

            if (map[dy][dx] < map[y][x]) {
                visited[dy][dx] = true;
                dfs(dy, dx, len + 1, cut);
                visited[dy][dx] = false;
            }

            else if (!cut && map[dy][dx] - k < map[y][x]) {
                int original = map[dy][dx];
                map[dy][dx] = map[y][x] - 1;
                visited[dy][dx] = true;
                dfs(dy, dx, len + 1, true);
                visited[dy][dx] = false;
                map[dy][dx] = original;
            }
        }
    }
}
