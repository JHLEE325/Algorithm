class Solution {
    static final int INF = 100_000_000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        s--; a--; b--;
        
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }
        }

        for (int[] fare : fares) {
            int u = fare[0] - 1;
            int v = fare[1] - 1;
            int cost = fare[2];
            map[u][v] = map[v][u] = cost;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int answer = INF;
        for (int k = 0; k < n; k++) {
            answer = Math.min(answer, map[s][k] + map[k][a] + map[k][b]);
        }

        return answer;
    }
}