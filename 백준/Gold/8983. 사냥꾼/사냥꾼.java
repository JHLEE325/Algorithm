import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 사대의 수
        int N = Integer.parseInt(st.nextToken()); // 동물의 수
        int L = Integer.parseInt(st.nextToken()); // 사정거리

        // 사대 위치 저장
        int[] launchers = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            launchers[i] = Integer.parseInt(st.nextToken());
        }

        // 동물 좌표 저장 (클래스나 배열 사용)
        int[][] animals = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            animals[i][0] = Integer.parseInt(st.nextToken()); // x
            animals[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        boolean[] isHunted = new boolean[N]; // 이미 잡힌 동물인지 체크
        int totalHunted = 0;

        // 1. 모든 사대를 하나씩 순회
        for (int i = 0; i < M; i++) {
            int currentLauncherX = launchers[i];

            // 2. 각 사대마다 모든 동물을 확인
            for (int j = 0; j < N; j++) {
                // 이미 다른 사대에서 잡힌 동물은 건너뜀
                if (isHunted[j]) continue;

                int animalX = animals[j][0];
                int animalY = animals[j][1];

                // 3. 거리 계산: |사대x - 동물x| + 동물y
                long distance = (long) Math.abs(currentLauncherX - animalX) + animalY;

                // 사정거리 이내라면 사냥 성공
                if (distance <= L) {
                    isHunted[j] = true;
                    totalHunted++;
                }
            }
        }

        System.out.println(totalHunted);
    }
}