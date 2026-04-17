import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int totalChildren = 0;
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++) {
                int candyCount = Integer.parseInt(st.nextToken());
                totalChildren += (candyCount / K);
            }

            System.out.println(totalChildren);
        }
    }
}