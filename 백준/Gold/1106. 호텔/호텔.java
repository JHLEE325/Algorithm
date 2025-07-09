import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int c, n;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[100001];

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<100001;i++){
            for(int j=0;j<n;j++){
                int cost = arr[j][0];
                int customer = arr[j][1];
                if(i - cost >= 0){
                    dp[i] = Math.max(dp[i], dp[i - cost] + customer);
                }
            }
            if(dp[i] >= c){
                answer = Math.min(answer, i);
            }
        }

        System.out.println(answer);
    }
}
