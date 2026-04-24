import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[] parent;
    static List<Edge> allEdges = new ArrayList<>();
    static List<Edge> selectedEdges = new ArrayList<>();

    static class Edge {
        int u, v;
        boolean used;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
            this.used = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = i + 1; j < N; j++) {
                if (line.charAt(j) == 'Y') {
                    allEdges.add(new Edge(i, j));
                }
            }
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        int mstCount = 0;
        for (Edge e : allEdges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                e.used = true;
                mstCount++;
                selectedEdges.add(e);
            }
        }

        if (mstCount != N - 1 || allEdges.size() < M) {
            System.out.println("-1");
            return;
        }

        int remaining = M - (N - 1);
        for (Edge e : allEdges) {
            if (remaining == 0) break;
            if (!e.used) {
                e.used = true;
                selectedEdges.add(e);
                remaining--;
            }
        }

        int[] cityCount = new int[N];
        for (Edge e : selectedEdges) {
            cityCount[e.u]++;
            cityCount[e.v]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : cityCount) {
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}