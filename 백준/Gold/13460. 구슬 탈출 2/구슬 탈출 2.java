import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][][][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Ball {
        int ry, rx, by, bx, depth;

        Ball(int ry, int rx, int by, int bx, int depth) {
            this.ry = ry; this.rx = rx;
            this.by = by; this.bx = bx;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][n][m];

        int ry = 0, rx = 0, by = 0, bx = 0;

        for (int y = 0; y < n; y++) {
            String str = br.readLine();
            for (int x = 0; x < m; x++) {
                char c = str.charAt(x);
                if (c == '#') map[y][x] = -1;
                else if (c == '.') map[y][x] = 0;
                else if (c == 'O') map[y][x] = 4;
                else if (c == 'R') {
                    map[y][x] = 0;
                    ry = y; rx = x;
                } else if (c == 'B') {
                    map[y][x] = 0;
                    by = y; bx = x;
                }
            }
        }

        System.out.println(bfs(ry, rx, by, bx));
    }

    static int bfs(int ry, int rx, int by, int bx) {
        Queue<Ball> q = new ArrayDeque<>();
        q.offer(new Ball(ry, rx, by, bx, 1));
        visited[ry][rx][by][bx] = true;

        while (!q.isEmpty()) {
            Ball cur = q.poll();

            if (cur.depth > 10) return -1;

            for (int d = 0; d < 4; d++) {
                int[] red = move(cur.ry, cur.rx, dir[d][0], dir[d][1]);
                int[] blue = move(cur.by, cur.bx, dir[d][0], dir[d][1]);

                int dry = red[0], drx = red[1], rc = red[2];
                int dby = blue[0], dbx = blue[1], bc = blue[2];

                if (map[dby][dbx] == 4) continue;
                if (map[dry][drx] == 4) return cur.depth;
                
                if (dry == dby && drx == dbx) {
                    if (rc > bc) {
                        dry -= dir[d][0];
                        drx -= dir[d][1];
                    } else {
                        dby -= dir[d][0];
                        dbx -= dir[d][1];
                    }
                }

                if (!visited[dry][drx][dby][dbx]) {
                    visited[dry][drx][dby][dbx] = true;
                    q.offer(new Ball(dry, drx, dby, dbx, cur.depth + 1));
                }
            }
        }
        return -1;
    }

    static int[] move(int y, int x, int dy, int dx) {
        int count = 0;
        while (map[y + dy][x + dx] != -1 && map[y][x] != 4) {
            y += dy;
            x += dx;
            count++;
            if (map[y][x] == 4) break;
        }
        return new int[]{y, x, count};
    }
}
