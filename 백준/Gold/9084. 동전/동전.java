import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.parseInt(br.readLine());
            int[] val = new int[max + 1];

            val[0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = coin[i]; j <= max; j++) {
                    val[j] += val[j - coin[i]];
                }
            }

            System.out.println(val[max]);
        }
    }
}
