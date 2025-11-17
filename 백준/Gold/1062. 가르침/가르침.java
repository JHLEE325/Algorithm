import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static String[] words;
    static boolean[] learned = new boolean[26];
    static int answer = 0;

    // 반드시 필요한 알파벳
    static final char[] essential = {'a', 'n', 't', 'i', 'c'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().trim();
        }

        // K가 5 이하라면 어떤 단어도 못 읽음
        if (K < 5) {
            System.out.println(0);
            return;
        }

        // 26개 다 가르치면 모든 단어 읽기 가능
        if (K == 26) {
            System.out.println(N);
            return;
        }

        // 필수 알파벳 등록
        for (char c : essential) {
            learned[c - 'a'] = true;
        }

        // DFS 돌릴 준비: 5개는 이미 배웠으므로 (K - 5)개를 더 선택해야 함
        dfs(0, 0);

        System.out.println(answer);
    }

    /**
     * @param idx: 현재 고려 중인 알파벳 (0~25)
     * @param count: 현재까지 추가로 배운 알파벳 개수 (필수 제외)
     */
    static void dfs(int idx, int count) {
        // K - 5 개 다 골랐으면 체크
        if (count == K - 5) {
            answer = Math.max(answer, countReadableWords());
            return;
        }

        // 26개를 모두 넘어가면 실패
        if (idx >= 26) return;

        // 이미 필수로 배운 알파벳이면 넘어감
        if (learned[idx]) {
            dfs(idx + 1, count);
        } else {
            // 1. 현재 알파벳을 배운다
            learned[idx] = true;
            dfs(idx + 1, count + 1);

            // 2. 현재 알파벳을 배우지 않는다 (원상복구)
            learned[idx] = false;
            dfs(idx + 1, count);
        }
    }

    // 현재 learned 배열로 몇 개의 단어를 읽을 수 있는지 체크
    static int countReadableWords() {
        int cnt = 0;

        for (String word : words) {
            boolean canRead = true;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!learned[c - 'a']) {
                    canRead = false;
                    break;
                }
            }

            if (canRead) cnt++;
        }

        return cnt;
    }
}
