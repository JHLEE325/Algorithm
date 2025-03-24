import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class node {
        int idx;
        int w;

        public node(int idx, int weight) {
            this.idx = idx;
            w = weight;
        }
    }

    static ArrayList<node>[] list;
    static boolean[] visited;
    static int maxWeight, farthestNode;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            while(true) {
                int c = Integer.parseInt(st.nextToken());
                if(c==-1)
                    break;
                int w = Integer.parseInt(st.nextToken());
                list[p].add(new node(c, w));
            }
        }

        visited = new boolean[n + 1];
        // 첫 번째 DFS로 임의의 노드에서 가장 먼 노드를 찾음
        dfs(1, 0);

        // 두 번째 DFS로 그 가장 먼 노드에서 다시 DFS를 해서 트리의 지름을 구함
        visited = new boolean[n + 1];
        dfs(farthestNode, 0);

        // 트리의 지름이 최대값
        System.out.println(maxWeight);
    }

    // DFS 함수
    public static void dfs(int idx, int weight) {
        visited[idx] = true;

        if (weight > maxWeight) {
            maxWeight = weight;
            farthestNode = idx;
        }

        for (node n : list[idx]) {
            if (!visited[n.idx]) {
                dfs(n.idx, weight + n.w);
            }
        }
    }
}
