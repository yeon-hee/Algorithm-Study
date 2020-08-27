import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1890_점프 {
	static int N,ans,array[][];
	static long temp[][]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		array = new int[N][N];
		temp = new long[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(temp[i], -1);
		}
		
		long answer = dfs(0,0);
		if(answer==-1) System.out.println(0);
		else System.out.println(answer);
	}
	
	static int dx[] = {0,1};
	static int dy[] = {1,0};
	static long dfs(int x, int y) {
		
		if(x==N-1 && y==N-1) return 1;
		
		if(temp[x][y]==-1) {
			temp[x][y] = 0;
			
			for(int i=0;i<2;i++) {
				int num = array[x][y];
				int nx = x + dx[i]*num;
				int ny = y + dy[i]*num;
				
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					temp[x][y] += dfs(nx,ny);
				}
			}
		}
		return temp[x][y];
	}
}
