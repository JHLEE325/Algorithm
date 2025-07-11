import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] lamp = new String[n];
        for (int i = 0; i < n; i++) {
            lamp[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());

        Map<String, Integer> count = new HashMap<>();

        for (String pattern : lamp) {
            count.put(pattern, count.getOrDefault(pattern, 0) + 1);
        }

        int answer = 0;

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String curpattern = entry.getKey();
            int curcount = entry.getValue();

            int zero = 0;
            for (char c : curpattern.toCharArray()) {
                if (c == '0') zero++;
            }

            if (zero <= k && (k - zero) % 2 == 0) {
                answer = Math.max(answer, curcount);
            }
        }

        System.out.println(answer);
    }
}
