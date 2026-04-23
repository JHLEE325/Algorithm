import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxLen = 0;
        List<Integer> resultList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(N);
            currentList.add(i);

            int index = 2;
            while (true) {
                int next = currentList.get(index - 2) - currentList.get(index - 1);
                
                if (next < 0) break;
                
                currentList.add(next);
                index++;
            }

            if (currentList.size() > maxLen) {
                maxLen = currentList.size();
                resultList = currentList;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLen).append("\n");
        for (int val : resultList) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}