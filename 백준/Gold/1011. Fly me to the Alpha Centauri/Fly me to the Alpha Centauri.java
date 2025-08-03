import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = y - x;

            int n = (int)Math.sqrt(d);

            if (d == n * n) {
                System.out.println(2 * n - 1);
            } else if (d <= n * (n + 1)) {
                System.out.println(2 * n);
            } else {
                System.out.println(2 * n + 1);
            }
        }
    }
}
