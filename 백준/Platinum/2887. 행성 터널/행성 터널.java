import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] parents;
    static int V;
    static int[][] vertex;
    static List<Edge> edgeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        vertex = new int[V + 1][3];
        parents = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            vertex[i][0] = Integer.parseInt(st.nextToken());
            vertex[i][1] = Integer.parseInt(st.nextToken());
            vertex[i][2] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        // 각 좌표별 정렬해서 인접한것만 edge에 넣음
        for (int d = 0; d < 3; d++) {
            final int dim = d;
            Integer[] idx = new Integer[V];
            for (int i = 0; i < V; i++) idx[i] = i + 1;

            Arrays.sort(idx, (a, b) -> Integer.compare(vertex[a][dim], vertex[b][dim]));

            for (int i = 0; i < V - 1; i++) {
                int from = idx[i];
                int to = idx[i + 1];
                int weight = Math.abs(vertex[from][dim] - vertex[to][dim]);
                edgeList.add(new Edge(from, to, weight));
            }
        }

        Collections.sort(edgeList);
        long result = 0;
        int count = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == V - 1) break;
            }
        }

        System.out.println(result);
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }
}
