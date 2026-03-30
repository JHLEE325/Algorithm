import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<Integer>[] adj;
    static int[] size;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        size = new int[N + 1];
        visited = new boolean[N + 1];

        countSubtreeNodes(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(size[q]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void countSubtreeNodes(int currentNode) {
        visited[currentNode] = true;
        size[currentNode] = 1;

        for (int nextNode : adj[currentNode]) {
            if (!visited[nextNode]) {
                countSubtreeNodes(nextNode);
                size[currentNode] += size[nextNode];
            }
        }
    }
}