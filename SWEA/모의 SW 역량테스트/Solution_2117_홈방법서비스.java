import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방법서비스 {
	
	static class Pair{
		int x; int y; int depth;
		public Pair(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	
	static int N,M,array[][],max,len;
	static Queue<Pair> queue;
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			queue = new LinkedList<Pair>();
			array = new int[N][N];
			max = Integer.MIN_VALUE;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k=1;k<=N+2;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						visited = new boolean[N][N];
						len = 0;
						if(array[i][j]==1) {
							len++;
							queue.offer(new Pair(i,j,0));
						}
						else queue.offer(new Pair(i,j,0));
						visited[i][j] = true;
						bfs(k);
					}
				}
			}
			
			System.out.println("#"+testcase+" "+max);
		}
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static void bfs(int num) {
		
		int money = num*num + (num-1)*(num-1); // 운영 비용
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			int y = current.y;
			int depth = current.depth;
			
			if(depth==num-1) { 
				int result = len*M - money; // 이익
				if(result>=0) max = Math.max(len, max); // 최대 집 수
				queue.clear();
				return; // 끝남
			}
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(array[nx][ny]==1) {
						len++;
						queue.offer(new Pair(nx,ny,depth+1));
					}
					else queue.offer(new Pair(nx,ny,depth+1));
				}
			}
		}
	}

}
