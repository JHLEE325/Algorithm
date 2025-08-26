import java.io.*;
import java.util.*;

/**
 * BOJ 23090 - 난민
 * 두 힙으로 하위 중앙값 유지 + 각 힙의 합을 들고 다니며 |y - median|의 합을 O(1)로 계산.
 * 총합 = sumAbsX + (median*sizeLow - sumLow) + (sumHigh - median*sizeHigh)
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        // 하위 중앙값을 위한 최대힙 (<= median), 상위 부분을 위한 최소힙 (> median)
        PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();

        long sumLow = 0L;   // low 힙 원소들의 합
        long sumHigh = 0L;  // high 힙 원소들의 합
        long sumAbsX = 0L;  // |x| 누적합

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 1) |x| 누적
            sumAbsX += Math.abs((long)x);

            // 2) y를 중앙값 구조에 삽입
            if (low.isEmpty() || y <= low.peek()) {
                low.offer(y);
                sumLow += y;
            } else {
                high.offer(y);
                sumHigh += y;
            }

            // 3) 균형 맞추기: 하위 중앙값을 쓰므로 size(low) >= size(high) && 차이는 최대 1
            if (low.size() < high.size()) {
                int mv = high.poll();
                sumHigh -= mv;
                low.offer(mv);
                sumLow += mv;
            } else if (low.size() > high.size() + 1) {
                int mv = low.poll();
                sumLow -= mv;
                high.offer(mv);
                sumHigh += mv;
            }

            // 4) 현재 하위 중앙값(최적 y)과 |y - median| 합 계산
            int median = low.peek();
            long sizeLow = low.size();
            long sizeHigh = high.size();

            long sumAbsY = median * sizeLow - sumLow      // low 쪽 기여
                         + sumHigh - median * sizeHigh;    // high 쪽 기여

            long total = sumAbsX + sumAbsY;

            out.append(median).append(' ').append(total).append('\n');
        }

        System.out.print(out);
    }
}
