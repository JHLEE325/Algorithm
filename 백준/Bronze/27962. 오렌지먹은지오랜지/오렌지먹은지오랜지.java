import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        boolean found = false;

        for (int k = 1; k < N; k++) {
            String prefix = s.substring(0, k);
            String suffix = s.substring(N - k, N);

            int diffCount = 0;
            for (int i = 0; i < k; i++) {
                if (prefix.charAt(i) != suffix.charAt(i)) {
                    diffCount++;
                }
                if (diffCount > 1) break;
            }

            if (diffCount == 1) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}