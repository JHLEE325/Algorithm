import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			S = sc.nextInt();
			count = 0;
			arr = new int[N];


			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			subset(0,0);

			System.out.println(count);
		}

	}

	static int[] arr;
	static int count;
	static int N;
	static int S;

	public static void subset(int cnt, int sum) {
		
		if (cnt == N) {
			if (sum == S) {
				count++;
			}
			return;
		}
		
		if(sum>S) {
			return;
		}


		subset(cnt + 1, sum+arr[cnt]);

		subset(cnt + 1,sum);
	}

}
