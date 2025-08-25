import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        Queue<int[]> list = new ArrayDeque<>();
        list.add(new int[] {0,0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0]=true;
        int cnt=1;
        if(n==1&&m==1){
            System.out.println(cnt);
            return;
        }

        while(!list.isEmpty()){
            int s = list.size();
            cnt++;
            for(int i=0;i<s;i++) {
                int[] cur = list.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    if (nr >= n || nr < 0 || nc >= m || nc < 0 || visited[nr][nc]||map[nr][nc]==0)
                        continue;
                    list.add(new int[] {nr,nc});
                    visited[nr][nc]=true;
                    if(nr==n-1&&nc==m-1){
                        System.out.println(cnt);
                        return;
                    }
                }
            }
        }
    }
}
