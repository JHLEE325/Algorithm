import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long ans = 0;

        Deque<Pair> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            int count = 1;

            while (!stack.isEmpty() && stack.peek().height < h) {
                ans += stack.poll().count;
            }

            if (!stack.isEmpty()) {
                if (stack.peek().height == h) {
                    Pair same = stack.pop();
                    ans += same.count;
                    count = same.count + 1;
                    if (!stack.isEmpty()) ans++;
                } else {
                    ans++;
                }
            }

            stack.push(new Pair(h, count));
        }

        System.out.println(ans);
    }

    static class Pair {
        int height, count;
        Pair(int h, int c) { height = h; count = c; }
    }
}
