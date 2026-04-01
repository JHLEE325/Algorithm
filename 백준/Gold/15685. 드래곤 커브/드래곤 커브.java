import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragonCurve(x, y, d, g);
        }

        System.out.println(count());
    }

    static void dragonCurve(int x, int y, int d, int g) {
        List<Point> points = new ArrayList<>();

        points.add(new Point(x, y));
        map[x][y] = true;

        x += dx[d];
        y += dy[d];
        points.add(new Point(x, y));
        map[x][y] = true;

        for (int i = 1; i <= g; i++) {
            Point pivot = points.get(points.size() - 1);
            int currentSize = points.size();

            for (int j = currentSize - 2; j >= 0; j--) {
                Point p = points.get(j);

                int nx = pivot.x - (p.y - pivot.y);
                int ny = pivot.y + (p.x - pivot.x);

                if (nx >= 0 && nx <= 100 && ny >= 0 && ny < 101) {
                    map[nx][ny] = true;
                    points.add(new Point(nx, ny));
                }
            }
        }
    }

    static int count() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    count++;
                }
            }
        }
        return count;
    }
}