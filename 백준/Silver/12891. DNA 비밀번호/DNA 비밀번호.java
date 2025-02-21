import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// HINT
	// 확인하는 배열을 4개로 하지 말고 T+1개로 해놓고 각 알파벳이 인덱스가 되게
	// dna 문자열의 첫 인덱스부터 요구되는 길이의 부분문자열의 A C G T 값을 구해놓고
	// 한칸씩 밀면서 삭제, 추가되는 원소만 확인하여 시간 절약
	// 실제 만들어지는 비밀번호가 뭐가 되는지는 신경 쓸 필요 없음 ( A C G T의 갯수만 중요)

	static int S, P, count;
	static int[] chk = new int['T' + 1];
	static int[] cur = new int['T' + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		count = 0;

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		st = new StringTokenizer(br.readLine());
		chk['A'] = Integer.parseInt(st.nextToken());
		chk['C'] = Integer.parseInt(st.nextToken());
		chk['G'] = Integer.parseInt(st.nextToken());
		chk['T'] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < P; i++) {
			cur[str.charAt(i)]++;
		}
		
		if (chk['A'] <= cur['A'] && chk['C'] <= cur['C'] && chk['G'] <= cur['G'] && chk['T'] <= cur['T']) {
			count++;
		}

		for (int i = 1; i <= S - P; i++) {
			cur[str.charAt(i - 1)]--;
			cur[str.charAt(i + P - 1)]++;

			if (chk['A'] <= cur['A'] && chk['C'] <= cur['C'] && chk['G'] <= cur['G'] && chk['T'] <= cur['T']) {
				count++;
			}
		}

		System.out.println(count);
	}

}