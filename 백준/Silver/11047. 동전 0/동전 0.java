import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];

        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt=0;

        for(int i=n-1;i>=0;i--){
            int div = k/coin[i];
            if(div!=0){
                k=k%coin[i];
                cnt+=div;
            }
        }
        System.out.println(cnt);
    }
}
