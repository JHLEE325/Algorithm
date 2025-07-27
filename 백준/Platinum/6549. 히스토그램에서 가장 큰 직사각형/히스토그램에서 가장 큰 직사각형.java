import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            long[] height = new long[n];
            for (int i = 0; i < n; i++) {
                height[i] = Long.parseLong(st.nextToken());
            }

            sb.append(getMaxArea(height)).append("\n");
        }

        System.out.print(sb);
    }

    static long getMaxArea(long[] height) {
        Stack<Integer> stack = new Stack<>();
        long max = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int top = stack.pop();
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height[top] * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            long width = stack.isEmpty() ? n : n - stack.peek() - 1;
            max = Math.max(max, height[top] * width);
        }

        return max;
    }
}
