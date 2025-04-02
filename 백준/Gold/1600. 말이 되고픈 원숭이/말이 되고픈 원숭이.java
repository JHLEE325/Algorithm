import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Place {
        int y, x, horse;

        public Place(int y, int x, int horse) {
            this.y = y;
            this.x = x;
            this.horse = horse;
        }
    }

    static int[][] map;
    static boolean[][][] visited;
    static int w, h, hnum;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int[][] hdir = {
        { -2, -1 }, { -1, -2 }, { -2, 1 }, { -1, 2 },
        { 2, -1 }, { 1, -2 }, { 2, 1 }, { 1, 2 }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        hnum = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][hnum + 1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<Place> queue = new ArrayDeque<>();
        queue.add(new Place(0, 0, 0));
        visited[0][0][0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Place cur = queue.poll();

                if (cur.y == h - 1 && cur.x == w - 1) {
                    System.out.println(steps);
                    return;
                }

                // 말 이동
                if (cur.horse < hnum) {
                    for (int d = 0; d < 8; d++) {
                        int ny = cur.y + hdir[d][0];
                        int nx = cur.x + hdir[d][1];

                        if (ny >= 0 && ny < h && nx >= 0 && nx < w &&
                            map[ny][nx] == 0 && !visited[ny][nx][cur.horse + 1]) {
                            visited[ny][nx][cur.horse + 1] = true;
                            queue.add(new Place(ny, nx, cur.horse + 1));
                        }
                    }
                }

                // 일반 이동
                for (int d = 0; d < 4; d++) {
                    int ny = cur.y + dir[d][0];
                    int nx = cur.x + dir[d][1];

                    if (ny >= 0 && ny < h && nx >= 0 && nx < w &&
                        map[ny][nx] == 0 && !visited[ny][nx][cur.horse]) {
                        visited[ny][nx][cur.horse] = true;
                        queue.add(new Place(ny, nx, cur.horse));
                    }
                }
            }

            steps++;
        }

        // 도달하지 못했을 경우
        System.out.println("-1");
    }
}
