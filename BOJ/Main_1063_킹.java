import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_킹 {
	static int N,array[][];
	static int dx[] = {0,0,1,-1,-1,-1,1,1};
	static int dy[] = {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String king = st.nextToken();
		array = new int[8][8];
		int x = 8 - (king.charAt(1) - '0');
		int y = king.charAt(0) - 'A';
		
		String rock = st.nextToken();
		int ax = 8 - (rock.charAt(1) - '0');
		int ay = rock.charAt(0) - 'A';
		array[ax][ay] = 1; // 돌의 위치
		
		N = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			String op = br.readLine();
			int dir = 0;
			switch(op) {
				case "R": dir = 0;
				break;
				case "L": dir = 1;
				break;
				case "B": dir = 2;
				break;
				case "T": dir = 3;
				break;
				case "RT": dir = 4;
				break;
				case "LT": dir = 5;
				break;
				case "RB": dir = 6;
				break;
				case "LB": dir = 7;
				break;
			}
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(0<=nx && nx<8 && 0<=ny && ny<8) {
				if(array[nx][ny]==1) { // 돌이 있는 경우
					nx += dx[dir];
					ny += dy[dir];
					if(0<=nx && nx<8 && 0<=ny && ny<8) {
						array[nx-dx[dir]][ny-dy[dir]] = 0;
						array[nx][ny] = 1; // 돌의 위치 변경
						x = nx-dx[dir];
						y = ny-dy[dir]; // 킹의 위치 변경
					}
				} else {
					x = nx;
					y = ny; // 킹의 위치 변경
				}
			}
		}
		
		String k = "";
		k += (char)('A' + y);
		k += 8 - x;
		
		System.out.println(k);
		k = "";
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(array[i][j]==1) {
					k += (char)('A' + j);
					k += 8 - i;
					System.out.println(k);
					return;
				}
			}
		}
		
	}

}
