import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, R;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		numbers = new int[R]; // 선택된 수 저장
		isSelected = new boolean[N + 1]; // 1부터 사용, 선택여부 저장
		
		permutation(0);
		
		System.out.println(sb);
	}

	static void permutation(int cnt) {
		
		if(cnt == R) {
			for(int a : numbers) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) { // 유도파트
			if (isSelected[i])
				continue;
			numbers[cnt] = i; // 선택한 수 저장
			isSelected[i] = true; // 선택한 수 플래그 저장
			permutation(cnt+1); // 다음 수 선택하러 재귀호출
			isSelected[i] = false;
		}
	}
}