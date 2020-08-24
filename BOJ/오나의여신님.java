import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 오나의여신님 {

	static class Pair{
		int x; int y; int cnt;
		public Pair(int x, int y, int cnt) {
			this(x, y);
			this.cnt = cnt;
		}
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N,M,hx,hy,ans;
	static char array[][];
	static Queue<Pair> suyeon;
	static Queue<Pair> devil;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int testcase=1;testcase<=T;testcase++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			hx = 0; hy = 0;
			array = new char[N][M];
			visited = new boolean[N][M];
			suyeon = new LinkedList<Pair>();
			devil = new LinkedList<Pair>();
			ans = Integer.MAX_VALUE;

			for(int i=0;i<N;i++){
				String str = br.readLine();
				for(int j=0;j<M;j++) {
					array[i][j] = str.charAt(j);
					if(array[i][j]=='S') {
						visited[i][j] = true;
						suyeon.offer(new Pair(i,j));
					}
					else if(array[i][j]=='*') {
						visited[i][j] = true;
						devil.offer(new Pair(i,j));
					}
					else if(array[i][j]=='D') {
						hx = i; hy = j;
					}
				}
			}

			bfs();
			
			System.out.print("#"+testcase+" ");
			if(ans==Integer.MAX_VALUE) System.out.println("GAME OVER");
			else System.out.println(ans);
		}
	}

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static void bfs() {


		while(!suyeon.isEmpty()) {
			
			int size = devil.size();
			for(int i=0;i<size;i++) {
				Pair current = devil.poll();
				int x = current.x;
				int y = current.y;
				
				for(int j=0;j<4;j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(0<=nx && nx<N && 0<=ny && ny<M && array[nx][ny]=='.') {
						devil.offer(new Pair(nx,ny));
						array[nx][ny] = '*';
					}
				}
			}
			
			size = suyeon.size();
			for(int i=0;i<size;i++) {
				Pair current = suyeon.poll();
				int x = current.x;
				int y = current.y;
				int cnt = current.cnt;
				
				if(x==hx && y==hy) {
					ans = cnt;
					return;
				}
				
				for(int j=0;j<4;j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(0<=nx && nx<N && 0<=ny && ny<M && array[nx][ny]!='*' && array[nx][ny]!='X' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						suyeon.offer(new Pair(nx,ny,cnt+1));
						array[nx][ny] = 'S';
					}
				}
			}
		}
	}
}
