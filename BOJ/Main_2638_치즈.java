import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
	
	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M,array[][],temp[][],result;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		temp = new int[N][M];
		boolean check = false;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visited = new boolean[N][M];
			check = false;
			bfs(0,0);
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(temp[i][j]>=2) {
						check = true;
						array[i][j] = 0;
					}
				}
				Arrays.fill(temp[i], 0);
			}
			if(!check) break;
			result++;
		}
		
		System.out.println(result);
		
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static void bfs(int x, int y) {
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(x,y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			x = current.x;
			y = current.y;
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny]) {
					if(array[nx][ny]==0) {
						visited[nx][ny] = true;
						queue.offer(new Pair(nx,ny));
					}
					else temp[nx][ny]++;
				}
			}
		}
	}

}
