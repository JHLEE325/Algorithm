import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int cnt=0;

        for(int t=0;t<T;t++){
            boolean[] visited = new boolean[26];
            String str = br.readLine();
            char flag = 0;
            int s = str.length();
            boolean isgroup=true;
            for(int i=0;i<s;i++){
                char c = str.charAt(i);
                if(!visited[c-'a']||c==flag){
                    flag = c;
                    visited[c-'a']=true;
                }
                else{
                    isgroup=false;
                    break;
                }
            }
            if(isgroup)
                cnt++;
        }

        System.out.println(cnt);
    }
}
