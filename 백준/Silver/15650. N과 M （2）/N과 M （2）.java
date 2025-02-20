import java.util.Scanner;

public class Main {
	static int N, R;
	static int[] input, numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N+1];

		for (int i = 1; i <= N; i++) {
			input[i] = i;
		}

		numbers = new int[R];

		combination(0, 1);
		
		System.out.println(sb);
	}

	static void combination(int cnt, int start) {

		if (cnt == R) {
			for(int a:numbers) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}
}
