import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int to, cost;
        
        Node(int t, int c) {
            to = t;
            cost = c;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        return bfs(n, graph);
    }
    
    public int bfs(int n, List<List<Integer>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        dist[1] = 0;
        
        int maxDist = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int next : graph.get(curr)) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    maxDist = Math.max(maxDist, dist[next]);
                    q.add(next);
                }
            }
        }
        
        int count = 0;
        for (int d : dist) {
            if (d == maxDist) count++;
        }
        
        return count;
    }
}