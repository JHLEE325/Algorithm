import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] box = new int[n][m];

        int start = Math.min(n, m);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        boolean found = false;

        for (int i = start; i > 0; i--) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    int tmp = box[a][b];
                    int right = a + i;
                    int below = b + i;
                    if (right >= n || below >= m)
                        continue;
                    else {
                        if (tmp == box[right][b] && tmp == box[right][below] && tmp == box[a][below]) {
                            System.out.println((int) Math.pow(i + 1, 2));
                            found = true;
                        }
                    }
                    if (found)
                        break;
                }
                if (found)
                    break;
            }
            if (found)
                break;
        }

        if (!found)
            System.out.println("1");
    }
}
