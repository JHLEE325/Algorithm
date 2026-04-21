import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static long maxSquare = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int dr = -N + 1; dr < N; dr++) {
                    for (int dc = -M + 1; dc < M; dc++) {
                        
                        if (dr == 0 && dc == 0) {
                            checkSquare(map[r][c]);
                            continue;
                        }

                        long currentNum = 0;
                        int currR = r;
                        int currC = c;

                        while (currR >= 0 && currR < N && currC >= 0 && currC < M) {
                            currentNum = currentNum * 10 + map[currR][currC];
                            checkSquare(currentNum);
                            
                            currR += dr;
                            currC += dc;
                        }
                    }
                }
            }
        }

        System.out.println(maxSquare);
    }

    static void checkSquare(long num) {
        long root = (long) Math.sqrt(num);
        if (root * root == num) {
            maxSquare = Math.max(maxSquare, num);
        }
    }
}