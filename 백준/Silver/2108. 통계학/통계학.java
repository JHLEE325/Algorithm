import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        double sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // 숫자 입력 및 map에 등장 횟수 기록
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            sum += arr[i];
        }

        // 1. 평균 (소수 첫째 자리 반올림)
        double avg = sum / n;
        sb.append(Math.round(avg)).append("\n");

        // 2. 중앙값
        Arrays.sort(arr);
        sb.append(arr[(n - 1) / 2]).append("\n");

        // 3. 최빈값
        List<Integer> modeList = new ArrayList<>();
        int maxFrequency = 0;
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                modeList.clear();
                modeList.add(key);
            } else if (frequency == maxFrequency) {
                modeList.add(key);
            }
        }

        // 최빈값이 여러 개일 경우 두 번째로 작은 값 선택
        if (modeList.size() > 1) {
            Collections.sort(modeList);
            sb.append(modeList.get(1)).append("\n");
        } else {
            sb.append(modeList.get(0)).append("\n");
        }

        // 4. 범위 (최댓값 - 최솟값)
        sb.append(arr[n - 1] - arr[0]).append("\n");

        // 출력
        System.out.println(sb);
    }
}