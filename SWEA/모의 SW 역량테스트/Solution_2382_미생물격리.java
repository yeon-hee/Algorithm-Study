import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 미생물격리 {
	
	static class Pair implements Comparable<Pair>{
		int x; int y; int cnt; int dir;
		public Pair(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
		
		public Pair(int cnt, int dir) {
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Pair o) {
			return o.cnt - this.cnt;
		}
	}
	static int N,M,K,result;
	static ArrayList<Pair> group[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			group = new ArrayList[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					group[i][j] = new ArrayList<>();
				}
			}
			result = 0;
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				group[x][y].add(new Pair(x,y,cnt,dir-1));
			}
			
			while(M-->0) {
				moveCell();
				plusCell();
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(group[i][j].size() > 0) {
						Pair first = group[i][j].get(0);
						result += first.cnt;
					}
				}
			}
			System.out.println("#"+testcase+" "+result);
		}
	}
	
	static void plusCell() {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int max = Integer.MIN_VALUE;
				if(group[i][j].size() > 1) {
					int sum = 0;
					int dir = 0;
					for(Pair a : group[i][j]) {
						sum += a.cnt;
						if(max < a.cnt) {
							max = a.cnt;
							dir = a.dir;
						}
					}
					group[i][j].clear();
					group[i][j].add(new Pair(i,j,sum,dir));
				}
			}
		}
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static void moveCell() { // 먼저 이동
		
		ArrayList<Pair> map[][] = new ArrayList[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(group[i][j].size() > 0) {
					for(Pair a : group[i][j]) {
						int x = a.x;
						int y = a.y;
						int cnt = a.cnt;
						int dir = a.dir;
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						if(nx==0 || nx==N-1 || ny==0 || ny==N-1) { // 방향 바꾸고 미생물 절반 죽음
							if(cnt/2 == 0) continue;
							if(dir%2 == 0) dir++;
							else dir--;
							cnt /= 2;
						}
						map[nx][ny].add(new Pair(nx,ny,cnt,dir));
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				group[i][j] = map[i][j];
			}
		}
	}
	
}
