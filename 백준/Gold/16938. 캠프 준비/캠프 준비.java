import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R, X, M, res, sum, max, min;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		isSelected = new boolean[N];
		res = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		subset(0,0);
		
		System.out.println(res);
	}

	public static void subset(int cnt, int pick) {
		if (cnt == N) {
			sum = 0;
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			if (pick >= 2) {
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						sum += numbers[i];
						if (max < numbers[i])
							max = numbers[i];
						if (min > numbers[i])
							min = numbers[i];
					}
				}

				if (sum >= L && sum <= R && (max - min) >= X)
					res++;
			}

			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1, pick + 1);

		isSelected[cnt] = false;
		subset(cnt + 1, pick);

	}

}
