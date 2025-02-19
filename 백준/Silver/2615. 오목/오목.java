import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Test5.txt"));
		//---------여기에 코드를 작성하세요.---------------//
		Scanner sc = new Scanner(System.in);
		
		int [][] plate = new int[19][19];
		boolean [][][] visited = new boolean[4][19][19];
		int[] dx = {-1,0,1,1};
		int[] dy = {1,1,1,0};
		int x;
		int y;
		int winner;
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				plate[i][j] = sc.nextInt();
			}
		}
		
		for(int j=0;j<19;j++) {
			for(int i=0;i<19;i++) {
				if(plate[i][j]==1) {
					for(int k=0;k<4;k++) {
						int num=0;
						if(!visited[k][i][j]) {
							for(int z=0;z<19;z++) {
								int ax = i + dx[k]*z;
								int ay = j + dy[k]*z;
								if(ax>=0 && ax<19 && ay>=0 && ay<19) {
									if(plate[ax][ay]==1&&!visited[k][ax][ay]) {
										num++;
										visited[k][ax][ay]=true;
									}
									else {
										break;
									}
								}
							}
						}
						if(num==5) {
							x=i+1;
							y=j+1;
							winner=1;
							System.out.println(winner);
							System.out.println(x+" "+y);
							return;
						}
					}
				}
				else if(plate[i][j]==2) {
					for(int k=0;k<4;k++) {
						int num=0;
						if(!visited[k][i][j]) {
							for(int z=0;z<19;z++) {
								int ax = i + dx[k]*z;
								int ay = j + dy[k]*z;
								if(ax>=0 && ax<19 && ay>=0 && ay<19) {
									if(plate[ax][ay]==2&&!visited[k][ax][ay]) {
										num++;
										visited[k][ax][ay]=true;
									}
									else {
										break;
									}
								}
							}
						}
						if(num==5) {
							x=i+1;
							y=j+1;
							winner=2;
							System.out.println(winner);
							System.out.println(x+" "+y);
							return;
						}
					}
				}
			}
		}
        System.out.println(0);
	sc.close();
}

}
