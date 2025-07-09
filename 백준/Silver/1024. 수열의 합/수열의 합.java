import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean found = false;

        for (int k = L; k <= 100; k++) {
            int tmp = N - (k * (k - 1)) / 2;
            if (tmp < 0) break;

            if (tmp % k == 0) {
                int x = tmp / k;
                if (x >= 0) {
                    for (int i = 0; i < k; i++) {
                        System.out.print((x + i) + " ");
                    }
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}
