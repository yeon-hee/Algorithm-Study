import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	static class Pair implements Comparable<Pair>{
		int x; int y; int time; int status;
		public Pair(int x, int y, int time, int status) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.status = status;
		}
		@Override
		public int compareTo(Pair o) {
			return array[o.x][o.y]-array[x][y];
		}
	}

	static int N,M,K,array[][],ans;
	static boolean visited[][];
	static PriorityQueue<Pair> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int testcase=1;testcase<=T;testcase++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 시간
			queue = new PriorityQueue<Pair>();
			array = new int[1000][1000];
			visited = new boolean[1000][1000];
			ans = 0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					array[500+i][500+j] = Integer.parseInt(st.nextToken());
					if(array[500+i][500+j]!=0) {
						visited[500+i][500+j] = true;
						queue.offer(new Pair(500+i,500+j,1,2));
					}
				}
			}

			bfs();
			System.out.println("#"+testcase+" "+ans);
		}

	}

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static void bfs() {

		int count = 0;
		PriorityQueue<Pair> temp = new PriorityQueue<Pair>();

		while(true) {
			
			for(Pair a : temp) queue.offer(a);
			temp.clear();
			
			while(!queue.isEmpty()) {

				if(count == K) {
					ans = queue.size();
					return;
				}

				Pair current = queue.poll();
				int x = current.x;
				int y = current.y;
				int time = current.time;
				int status = current.status;

				if(status==1) { // 활성 상태인것 

					for(int i=0;i<4;i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];

						if(0<=nx && nx<1000 && 0<=ny && ny<1000 && !visited[nx][ny]) {
							visited[nx][ny] = true;
							temp.offer(new Pair(nx,ny,1,2));
							array[nx][ny] = array[x][y];
						}
					}
				}

				if(array[x][y]==time) temp.offer(new Pair(x,y,time+1,1)); // 활성상태가 됨 
				else if(array[x][y]*2==time) continue; // 죽은 상태
				else temp.offer(new Pair(x,y,time+1,status));
			}
			count++;
		}
	}

}
