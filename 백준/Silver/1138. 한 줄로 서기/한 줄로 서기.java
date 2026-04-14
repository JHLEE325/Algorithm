import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int leftCount = Integer.parseInt(st.nextToken());

            for (int j = 0; j < N; j++) {
                if (leftCount == 0 && result[j] == 0) {
                    result[j] = i;
                    break;
                }
                
                if (result[j] == 0) {
                    leftCount--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : result) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}