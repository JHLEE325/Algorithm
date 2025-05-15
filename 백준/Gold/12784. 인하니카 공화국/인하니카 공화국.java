import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] graph;
    static boolean[] visited;

    static class Node {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==1) {
            	System.out.println("0");
            	continue;
            }
            
            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph[from].add(new Node(to, cost));
                graph[to].add(new Node(from, cost));
            }

            int res = dfs(1, 987654321);
            System.out.println(res);
        }
    }

    public static int dfs(int cur, int parent) {
        visited[cur] = true;
        int sum = 0;
        boolean last = true;

        for (Node next : graph[cur]) {
            if (!visited[next.to]) {
                last = false;
                sum += dfs(next.to, next.cost);
            }
        }

        if (last) return parent;
        return Math.min(parent, sum);
    }
}
