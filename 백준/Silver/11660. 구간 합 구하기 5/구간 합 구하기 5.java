import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] grid = new int[N+1][N+1];
        
        for(int i=1;i<=N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1;j<=N;j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		grid[i][j] = tmp + grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
        	}
        }

        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	int res = grid[x2][y2] - grid[x1-1][y2] - grid[x2][y1-1] + grid[x1-1][y1-1];
        	sb.append(res).append("\n");
        }
        
        System.out.println(sb);
    }
    
}
