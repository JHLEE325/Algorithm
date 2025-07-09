import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            int[][] point = new int[2][2];
            point[0][0] = Integer.parseInt(st.nextToken());
            point[0][1] = Integer.parseInt(st.nextToken());
            point[1][0] = Integer.parseInt(st.nextToken());
            point[1][1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int answer = 0;

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                boolean start = false, end = false;
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                double distance = Math.sqrt(Math.pow(point[0][0]-x,2) + Math.pow(point[0][1]-y,2));
                if(distance<r){
                    start = true;
                }
                double distance2 = Math.sqrt(Math.pow(point[1][0]-x,2) + Math.pow(point[1][1]-y,2));
                if(distance2<r){
                    end = true;
                }

                if(start == end)
                    continue;
                else answer++;
            }
            System.out.println(answer);
        }
    }
}
