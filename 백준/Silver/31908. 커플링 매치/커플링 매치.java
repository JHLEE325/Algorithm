import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, List<String>> groups = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();

            if (ring.equals("-")) continue;

            groups.putIfAbsent(ring, new ArrayList<>());
            groups.get(ring).add(name);
        }

        List<String[]> couples = new ArrayList<>();

        for (String key : groups.keySet()) {
            List<String> members = groups.get(key);
            if (members.size() == 2) {
                couples.add(new String[]{members.get(0), members.get(1)});
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(couples.size()).append("\n");
        for (String[] couple : couples) {
            sb.append(couple[0]).append(" ").append(couple[1]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}