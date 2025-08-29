import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[][] bit = new boolean[m+1][1024];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Math.abs(Integer.parseInt(st.nextToken()));
            bit[1][arr[i]]=true;
        }

        for (int k = 2; k <= m; k++) {
            for (int x = 0; x < 1024; x++) {
                if (!bit[k - 1][x]) continue;
                for (int v : arr) {
                    bit[k][x ^ v] = true;
                }
            }
        }

        for (int x = 1023; x >= 0; x--) {
            if (bit[m][x]) {
                System.out.println(x);
                return;
            }
        }
        System.out.println(0);
    }
}