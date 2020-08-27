import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내리막길 {
	
	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M,array[][],temp[][],ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(temp[i], -1);
		}
		
		int answer = dfs(0,0);
		System.out.println(answer);
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int dfs(int x, int y) {
		
		if(x==N-1 && y==M-1) return 1;
		
		if(temp[x][y]==-1) {
			temp[x][y] = 0;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M && array[x][y]>array[nx][ny]) {
					temp[x][y] += dfs(nx,ny);
				}
			}
		}
		return temp[x][y];
	}
}
