import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();
        int tLength = text.length;
        int pLength = pattern.length;

        int[] pi = new int[pLength]; // 부분일치 테이블(실패함수) 만들기 : 패턴에서 불일치가 발생할 경우 활용해서 패턴포인터 이동 목적
        for (int i = 1, j = 0; i < pLength; i++) { // 패턴에서 패턴을 찾는원리를 이용
            // i: 패턴의 접미사,  j: 패턴의 접두사
            // 두 포인터의 위치에서 불일치가 발생하면 맞은 직전위치의 정보를 활용해서 불필요한 비교를 줄임
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }

            // 현재 i위치까지의 부분문자열의 접미사가 접두사와 일치하는 패턴의 최장길이 저장
            if (pattern[i] == pattern[j]) {
                pi[i] = ++j; // j위치까지 일치한 경우 길이는 j+1, 후에 j 뒤로 이동
            } else {
                pi[i] = 0;  // 일치하는 접두사 접미사 없음
            }
        }

        //System.out.println(Arrays.toString(pi));

        int cnt = 0;
        Deque<Integer> list = new ArrayDeque<>();

        for (int i = 0, j = 0; i < tLength; i++) {

            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (text[i] == pattern[j]) {
                if (j == pLength - 1) { // 일치가 발생한 위치가 패턴의 끝이면
                    ++cnt; // 패턴 찾았으므로 카운트 증가
                    list.addLast(i - j);
                    j = pi[j];
                } else {
                    ++j;
                }
            }
        }

        System.out.println(cnt);

        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            sb.append(list.pollFirst() + 1 + " ");
        }
        System.out.println(sb.toString());
    }


}
