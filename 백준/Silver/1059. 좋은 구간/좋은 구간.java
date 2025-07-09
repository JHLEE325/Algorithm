import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int[] s = new int[l];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());
        Arrays.sort(s);

        // n이 이미 존재하면 좋은 구간은 없음
        for (int x : s) {
            if (x == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;
        int right = 0;

        // n보다 작은 가장 큰 값 찾기
        for (int x : s) {
            if (x < n) left = x;
            else {
                right = x;
                break;
            }
        }

        int result = (n - left) * (right - n) - 1;
        System.out.println(result);
    }
}
