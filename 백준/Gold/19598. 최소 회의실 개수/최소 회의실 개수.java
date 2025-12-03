import java.io.*;
import java.util.*;

public class Main {

    static class Meeting {
        int s, e;
        Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Meeting[] arr = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Meeting(s, e);
        }

        Arrays.sort(arr, (a, b) -> a.s - b.s);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int start = arr[i].s;
            int end   = arr[i].e;

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}
