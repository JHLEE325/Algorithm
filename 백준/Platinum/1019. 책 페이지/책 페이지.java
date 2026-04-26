import java.io.*;
import java.util.*;

public class Main {
    
    static long[] counts = new long[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long start = 1;
        long end = n;
        long point = 1;

        while (start <= end) {
            while (start % 10 != 0 && start <= end) {
                countDigits(start, point);
                start++;
            }

            if (start > end) break;

            while (end % 10 != 9 && start <= end) {
                countDigits(end, point);
                end--;
            }

            long diff = (end / 10 - start / 10 + 1);
            for (int i = 0; i < 10; i++) {
                counts[i] += diff * point;
            }

            start /= 10;
            end /= 10;
            point *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (long count : counts) {
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void countDigits(long num, long point) {
        while (num > 0) {
            counts[(int)(num % 10)] += point;
            num /= 10;
        }
    }
}