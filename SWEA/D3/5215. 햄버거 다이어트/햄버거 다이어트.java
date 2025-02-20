import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] numbers;
	static int M,N,L,mscore=0;
	static int[] score;
	static int[] cal;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			mscore=0;
			
			score = new int[N];
			cal = new int[N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) {
				M=i;
				numbers = new int[M];
				dice4(0,0);
			}
			sb.append("#"+t+" "+mscore+"\n");
		}
		
		System.out.println(sb);
	}
	
	static void dice4(int cnt, int start) { // 조합
		if (cnt == M) {
			int tmpscore=0;
			int tmpcal=0;
			for(int i=0;i<M;i++) {
				tmpcal+=cal[numbers[i]];
				tmpscore+=score[numbers[i]];
			}
			if(tmpcal<=L) {
				if(mscore<tmpscore) {
					mscore=tmpscore;
				}
			}
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}

}
