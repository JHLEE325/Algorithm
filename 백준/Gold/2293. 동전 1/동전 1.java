import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            int[] val = new int[max + 1];
            int[] coin = new int[n];

            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(br.readLine());
            }


            val[0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = coin[i]; j <= max; j++) {
                    val[j] += val[j - coin[i]];
                }
            }

            System.out.println(val[max]);
        
    }
}
