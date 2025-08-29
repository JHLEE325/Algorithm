import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int t, int c) {
            this.to = t;
            this.cost = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n, m, x;
    static ArrayList<Node>[] graph1;
    static ArrayList<Node>[] graph2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph1 = new ArrayList[n + 1];
        graph2 = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph1[from].add(new Node(to, cost));
            graph2[to].add(new Node(from, cost));
        }
        int[] dist = Dijkstra(x);
        int[] dist2 = Dijkstra2(x);
        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i] + dist2[i]);
        }
        System.out.println(max);
    }

    public static int[] Dijkstra(int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, 987654321);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int cur = pq.poll().to;

            if (check[cur])
                continue;
            check[cur] = true;

            for (Node next : graph1[cur]) {
                if (dist[next.to] > dist[cur] + next.cost) {
                    dist[next.to] = dist[cur] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }

    public static int[] Dijkstra2(int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, 987654321);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int cur = pq.poll().to;

            if (check[cur])
                continue;
            check[cur] = true;

            for (Node next : graph2[cur]) {
                if (dist[next.to] > dist[cur] + next.cost) {
                    dist[next.to] = dist[cur] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}