import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] countMap = new int[n][m];
        int totalNine = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int cnt = countNine(st.nextToken());
                countMap[i][j] = cnt;
                totalNine += cnt;
            }
        }

        int maxNineInLine = 0;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += countMap[i][j];
            }
            maxNineInLine = Math.max(maxNineInLine, rowSum);
        }

        for (int j = 0; j < m; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += countMap[i][j];
            }
            maxNineInLine = Math.max(maxNineInLine, colSum);
        }

        System.out.println(totalNine - maxNineInLine);
    }

    static int countNine(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '9') count++;
        }
        return count;
    }
}