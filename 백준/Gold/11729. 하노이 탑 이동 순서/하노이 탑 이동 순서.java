import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3);

        System.out.println(count);
        System.out.println(sb.toString());
    }

    static void hanoi(int n, int now, int destination) {
        if (n == 1) {
            sb.append(now)
                    .append(" ")
                    .append(destination)
                    .append("\n");
            count++;
            return;
        }
        int other = 6 - now - destination;
        hanoi(n - 1, now, other);
        sb.append(now)
                .append(" ")
                .append(destination)
                .append("\n");
        count++;
        hanoi(n - 1, other, destination);
    }
}
