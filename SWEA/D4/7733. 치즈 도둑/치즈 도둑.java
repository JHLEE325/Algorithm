import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N, ans, max;
    static int[][] map; // 치즈 배열
    static boolean[][] chk; // 방문 확인용
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 4방탐색

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 1; // 0일차 처리
            for (int num = 1; num <= 100; num++) { // 100일 동안 수행
                chk = new boolean[N][N];
                ans = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!chk[i][j] && map[i][j] > num) {
                            bfs(i, j, num);
                            ans++;
                        }
                    }
                }
                if (max < ans) {
                    max = ans;
                }
            }

            sb.append("#" + t + " " + max + "\n");
        }

        System.out.println(sb);
    }

    // BFS로 영역을 찾는 함수
    public static void bfs(int y, int x, int num) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        chk[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];

            for (int i = 0; i < 4; i++) {
                int dy = cy + dir[i][0];
                int dx = cx + dir[i][1];

                // 경계 체크
                if (dy >= 0 && dy < N && dx >= 0 && dx < N && !chk[dy][dx] && map[dy][dx] > num) {
                    chk[dy][dx] = true;
                    queue.offer(new int[]{dy, dx});
                }
            }
        }
    }
}
