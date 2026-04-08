import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] pokemonArr = new String[N + 1];
        HashMap<String, Integer> pokemonMap = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pokemonArr[i] = name;
            pokemonMap.put(name, i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            
            if (Character.isDigit(s.charAt(0))) {
                int num = Integer.parseInt(s);
                sb.append(pokemonArr[num]).append("\n");
            } else {
                sb.append(pokemonMap.get(s)).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}