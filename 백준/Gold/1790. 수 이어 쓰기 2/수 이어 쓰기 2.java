import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        if (calcLen(N) < K) {
            System.out.println("-1");
            return;
        }

        long low = 1, high = N;
        long target = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (calcLen(mid) >= K) {
                target = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        String s = String.valueOf(target);
        long beforeLen = calcLen(target - 1);
        int index = (int) (K - beforeLen - 1);
        
        System.out.println(s.charAt(index));
    }

    static long calcLen(long n) {
        long total = 0;
        for (long start = 1, len = 1; start <= n; start *= 10, len++) {
            long end = start * 10 - 1;
            if (end > n) end = n;
            total += (end - start + 1) * len;
        }
        return total;
    }
}