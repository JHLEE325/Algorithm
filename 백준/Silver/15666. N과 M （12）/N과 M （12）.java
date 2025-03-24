import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] list, res;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n];
        res = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list); // 배열을 정렬하여 중복된 순열을 쉽게 처리

        // 비내림차순 수열 생성
        generateSequences(0, 0);
    }

    static void generateSequences(int cnt, int start) {
        if (cnt == m) {
            // m개의 수가 다 선택되었으면 출력
        	StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(res[i]+" ");
			}
			
			String seq = sb.toString().trim();
			
			if(!set.contains(seq)) {
				set.add(seq);
				System.out.println(seq);
			}
            return;
        }

        for (int i = start; i < n; i++) {
            res[cnt] = list[i];
            generateSequences(cnt + 1, i); // i부터 시작하여 이전 값보다 작은 값을 선택하지 않음
        }
    }
}
