import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static final int MOD = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] pow(int[][] a, long exp) {
        if (exp == 1L) {
            return a;
        }

        int[][] half = pow(a, exp / 2);

        int[][] res = multiply(half, half);

        if (exp % 2 == 1L) {
            res = multiply(res, a);
        }

        return res;
    }

    static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    tmp[i][j] += m1[i][k] * m2[k][j];
                    tmp[i][j] %= MOD;
                }
            }
        }
        return tmp;
    }
}