import java.util.*;
import java.io.*;

public class Main {

    static Map<Long, Long> mem = new HashMap<>();
    static int p, q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        mem.put(0L, 1L);

        System.out.println(arr(n));
    }

    static long arr(long i) {
        if (i == 0) return 1;

        if (mem.containsKey(i)) {
            return mem.get(i);
        }

        long temp = arr(i / p) + arr(i / q);

        mem.put(i, temp);

        return temp;
    }
}