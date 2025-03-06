import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static int R, C;
    static int max = 0;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        Set<Character> visited = new HashSet<>();
        dfs(0, 0, visited, 0);
        System.out.println(max);
    }

    static void dfs(int y, int x, Set<Character> visited, int count) {
        if (visited.contains(board[y][x])) {
            // 이미 방문한 알파벳이 있다면 더 이상 진행하지 않음
            max = Math.max(max, count);
            return;
        }

        // 현재 문자를 방문한 것으로 표시
        visited.add(board[y][x]);
        max = Math.max(max, count + 1);

        // 4방향으로 탐색
        for (int i = 0; i < 4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                dfs(ny, nx, visited, count + 1);
            }
        }

        // 백트래킹: 해당 알파벳을 방문하지 않은 것으로 되돌림
        visited.remove(board[y][x]);
    }
}
