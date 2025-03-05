import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, r, c, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        result = 0;

        zsearch(N, 0, 0);
        
        System.out.println(result);
    }

    public static void zsearch(int n, int y, int x) {
        if (n == 0) {
            // 목적지 도달
            if (y == r && x == c) {
                return;
            }
            return;
        }

        int size = (int) Math.pow(2, n - 1);
        
        // 좌상단
        if (r < y + size && c < x + size) {
            zsearch(n - 1, y, x);
        }
        // 우상단
        else if (r < y + size && c >= x + size) {
            result += size * size;
            zsearch(n - 1, y, x + size);
        }
        // 좌하단
        else if (r >= y + size && c < x + size) {
            result += 2 * size * size;
            zsearch(n - 1, y + size, x);
        }
        // 우하단
        else {
            result += 3 * size * size;
            zsearch(n - 1, y + size, x + size);
        }
    }
}
