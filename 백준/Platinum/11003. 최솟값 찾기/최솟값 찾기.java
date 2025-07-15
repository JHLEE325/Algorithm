import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        Deque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int cur = arr[i];

            while (!list.isEmpty() && arr[list.peekLast()] > cur) {
                list.pollLast();
            }

            list.addLast(i);

            if (list.peekFirst() <= i - l) {
                list.pollFirst();
            }

            sb.append(arr[list.peekFirst()] + " ");
        }

        System.out.println(sb.toString());
    }


}
