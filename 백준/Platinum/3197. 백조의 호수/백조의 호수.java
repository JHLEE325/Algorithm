import java.io.*;
import java.util.*;

public class Main {
    
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> nextWaterQ = new LinkedList<>();
    static Queue<int[]> swanQ = new LinkedList<>();
    static Queue<int[]> nextSwanQ = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[] swanPos = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        int swanIdx = 0;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] != 'X') waterQ.add(new int[]{i, j});
                if (map[i][j] == 'L') {
                    swanPos[0] = i;
                    swanPos[1] = j;
                }
            }
        }

        swanQ.add(new int[]{swanPos[0], swanPos[1]});
        visited[swanPos[0]][swanPos[1]] = true;

        int days = 0;
        while (true) {
            if (moveSwan()) break;
            
            meltIce();
            
            swanQ = nextSwanQ;
            waterQ = nextWaterQ;
            nextSwanQ = new LinkedList<>();
            nextWaterQ = new LinkedList<>();
            days++;
        }
        System.out.println(days);
    }

    static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            int[] curr = swanQ.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i], nc = curr[1] + dc[i];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                if (map[nr][nc] == 'L') return true;
                if (map[nr][nc] == 'X') {
                    nextSwanQ.add(new int[]{nr, nc});
                } else {
                    swanQ.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }

    static void meltIce() {
        while (!waterQ.isEmpty()) {
            int[] curr = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i], nc = curr[1] + dc[i];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                if (map[nr][nc] == 'X') {
                    map[nr][nc] = '.';
                    nextWaterQ.add(new int[]{nr, nc});
                }
            }
        }
    }
}