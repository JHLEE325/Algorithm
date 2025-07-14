import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> list = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!list.isEmpty() && list.peek() > y) {
                list.pop();
                count++;
            }

            if (list.isEmpty() || list.peek() < y) {
                if(y!=0)
                    list.push(y);
            }
        }

        count += list.size();

        System.out.println(count);
    }
}
