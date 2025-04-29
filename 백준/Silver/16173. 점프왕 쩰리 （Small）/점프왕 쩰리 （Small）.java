import java.io.*;
import java.util.*;

public class Main {

	static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(found ? "HaruHaru" : "Hing");
    }

    public static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        if (map[x][y] == -1) {
            found = true;
            return;
        }

        int jump = map[x][y];
        dfs(x + jump, y);
        dfs(x, y + jump);
    }
}
