import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        long minRss = Long.MAX_VALUE;
        int bestA = 0;
        int bestB = 0;

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                long currentRss = 0;

                for (int i = 0; i < N; i++) {
                    long diff = (long) points[i].y - (a * points[i].x + b);
                    currentRss += (diff * diff);
                }

                if (currentRss < minRss) {
                    minRss = currentRss;
                    bestA = a;
                    bestB = b;
                }
            }
        }

        System.out.println(bestA + " " + bestB);
    }
}