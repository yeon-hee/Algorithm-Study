import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_마법사상어와파이어스톰 {

	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,Q,array[][],len;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		len = (int) Math.pow(2, N);
		array = new int[len][len];
		visited = new boolean[len][len];
		int sum = 0;
		int answer = 0;

		for(int i=0;i<len;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<len;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			int num = Integer.parseInt(st.nextToken());
			lotate(num);
			Water();
		}

		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(array[i][j]>0) sum += array[i][j];
				if(array[i][j]>0 && !visited[i][j]) {
					visited[i][j] = true;
					int num = bfs(i,j,0);
					answer = Math.max(answer, num);
				}
			}
		}

		System.out.println(sum);
		System.out.println(answer);
	}

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	static int bfs(int x, int y, int cnt) {
		
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(x,y));
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			x = current.x;
			y = current.y;
			cnt++;
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<len && 0<=ny && ny<len && !visited[nx][ny]) {
					if(array[nx][ny]>0) {
						visited[nx][ny] = true;
						queue.offer(new Pair(nx,ny));
					}
				}
			}
		}
		
		return cnt;
		
	}
	static void Water() {
		
		boolean map[][] = new boolean[len][len];
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				int cnt = 0;
				for(int k=0;k<4;k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(0<=nx && nx<len && 0<=ny && ny<len && array[nx][ny]>0) {
						cnt++;
					}
				}
				if(cnt < 3) map[i][j] = true; 
			}
		}
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(map[i][j]) array[i][j]--;
			}
		}
		
	}
	
	static void lotate(int num) {

		num = (int) Math.pow(2, num);
		int map[][] = new int[len][len];

		int x = 0;
		int y = 0;

		L:while(true) {
			int count = x;
			int step = 1;
			for(int i=x;i<x+num;i++) { // 회오리 회전
				for(int j=y;j<y+num;j++) {
					if(count == len) break L;
					map[count][y+num-step] = array[i][j];
					count++;
				}
				count = x;
				step++;
			}
			
			if(y+num == len) {
				y = 0;
				x += num;
			}
			else y += num;
		}
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				array[i][j] = map[i][j];
			}
		}
	}

}
