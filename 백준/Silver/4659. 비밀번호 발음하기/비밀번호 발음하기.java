import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			boolean hasmo = false;
			char[] moem = {'a','e','i','u','o'};
			int seqcount=0;
			boolean sameduple = false;
			if(str.equals("end")) {
				break;
			}
			
			sb.append("<"+str+"> ");
			
			char[] strchar = str.toCharArray();
			
			for(int i=0;i<str.length();i++) {
				boolean ismo = false;
				for(int j=0;j<5;j++) {
					if(strchar[i]==moem[j]) {
						hasmo = true;
						ismo = true;
						if(seqcount<0) {
							seqcount=0;
						}
						seqcount++;
					}
				}
				if(!ismo) {
					if(seqcount>0) {
						seqcount=0;
					}
					seqcount--;
				}
				
				if(i+1<str.length()) {
					if(strchar[i]!='e'&&strchar[i]!='o') {
						if(strchar[i]==strchar[i+1]) {
							sameduple = true;
						}
					}
				}
				
				if(Math.abs(seqcount)>2||sameduple) {
					break;
				}
			}
			
			if(Math.abs(seqcount)<3&&!sameduple&&hasmo) {
				sb.append("is acceptable.\n");
			}
			else {
				sb.append("is not acceptable.\n");
			}
			
		}
		System.out.println(sb);
	}

}