import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, K;
    static List<Integer>[] adj;
    static int[] depth;
    static int[][] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null) return;
        N = Integer.parseInt(line.trim());

        K = 18; 
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) continue;
            
            StringTokenizer st = new StringTokenizer(input);
            if (st.countTokens() < 2) continue;
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        depth = new int[N + 1];
        parent = new int[K][N + 1];

        bfs(1);

        for (int k = 1; k < K; k++) {
            for (int i = 1; i <= N; i++) {
                parent[k][i] = parent[k - 1][parent[k - 1][i]];
            }
        }

        line = br.readLine();
        if (line == null) return;
        M = Integer.parseInt(line.trim());
        
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String query = br.readLine();
            if (query == null || query.isEmpty()) continue;
            
            StringTokenizer st = new StringTokenizer(query);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCA(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        depth[root] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj[curr]) {
                if (depth[next] == 0) {
                    depth[next] = depth[curr] + 1;
                    parent[0][next] = curr;
                    q.add(next);
                }
            }
        }
    }

    static int getLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a; a = b; b = temp;
        }

        for (int k = K - 1; k >= 0; k--) {
            if (depth[b] - depth[a] >= (1 << k)) {
                b = parent[k][b];
            }
        }

        if (a == b) return a;

        for (int k = K - 1; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        return parent[0][a];
    }
}