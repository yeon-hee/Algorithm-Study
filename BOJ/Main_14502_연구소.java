import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {

	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M,array[][],temp[],map[][];
	static int ans = Integer.MIN_VALUE;
	static boolean visited[][];
	static ArrayList<Pair> list = new ArrayList<Pair>();
	static ArrayList<Pair> virus = new ArrayList<Pair>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		map = new int[N][M];
		temp = new int[3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j]==0) list.add(new Pair(i,j));
				else if(array[i][j]==2) virus.add(new Pair(i,j)); // 바이러스
			}
		}
		
		subset(0,0);
		System.out.println(ans);
		
	}
	
	static void subset(int index, int cnt) {
		
		if(index==3) {
			
			for(int i=0;i<N;i++) map[i] = array[i].clone();
			
			for(int i=0;i<3;i++) { // 벽치기
				Pair a = list.get(temp[i]);
				map[a.x][a.y] = 1;
			}
			
			virus();
			return;
		}
		
		for(int i=cnt;i<list.size();i++) {
			temp[index] = i;
			subset(index+1,i+1);
		}
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static void virus() {
		
		int count = 0;
		Queue<Pair> queue = new LinkedList<Pair>();
		visited = new boolean[N][M];
		
		for(Pair a : virus) {
			visited[a.x][a.y] = true;
			queue.offer(a);
		}
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			int y = current.y;
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && map[nx][ny]==0) {
					visited[nx][ny] = true;
					map[nx][ny] = 1;
					queue.offer(new Pair(nx,ny));
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) count++;
			}
		}
		ans = Math.max(ans, count);
	}
}
