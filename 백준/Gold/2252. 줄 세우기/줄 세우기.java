import java.io.*;
import java.util.*;

public class Main {

    static int v, e;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        indegree = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                if (--indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
