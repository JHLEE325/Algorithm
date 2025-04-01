import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, res;
    static int[][] map;
    static boolean[] visited;
    static int startCity;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        res = Integer.MAX_VALUE;

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 도시를 시작점으로 시도
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            startCity = i; // 시작 도시 저장
            tsp(i, 0, 1);  // 시작 도시부터 탐색 시작 (1개 방문했으므로 count=1)
        }

        System.out.println(res);
    }

    static void tsp(int cur, int weight, int count) {
        if (count == n) {
            // 모든 도시를 방문한 후, 시작 도시로 돌아갈 수 있는 경우만
            if (map[cur][startCity] != 0) {
                res = Math.min(res, weight + map[cur][startCity]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[cur][i] != 0) {
                visited[i] = true;
                tsp(i, weight + map[cur][i], count + 1);
                visited[i] = false;
            }
        }
    }
}
