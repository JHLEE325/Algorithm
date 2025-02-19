import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static class rank {
        int score;
        int index;

        public rank(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int taesoo = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		if(N==0) {
			sb.append("1");
		}
		else {
			LinkedList<rank> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(new rank(Integer.parseInt(st.nextToken()),i));
			}
			rank r = new rank(taesoo,N);
			list.add(r);
			list.sort(new Comparator<rank>() {
				@Override
				public int compare(rank o1, rank o2) {
					// TODO Auto-generated method stub
					return o2.score-o1.score;
				}
			});
			
			if(list.indexOf(r)+1>P) {
				sb.append("-1");
			}
			else {
				for(int i=0;i<=list.indexOf(r);i++) {
					if(list.get(i).score==r.score) {
						sb.append(list.indexOf(list.get(i))+1);
                        break;
					}
				}
			}
		}
		
		System.out.println(sb);
		
		
	}

}
