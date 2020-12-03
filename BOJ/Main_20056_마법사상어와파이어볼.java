import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼 {
	
	static class Pair{
		int x; int y; int m; int speed; int dir;
		public Pair(int x, int y, int m, int speed, int dir) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.speed = speed;
			this.dir = dir;
		}
	}
	static int N,M,K,array[][],magic[][];
	static ArrayList<Pair> fire[][];
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		magic = new int[M][5];
		fire = new ArrayList[N+1][N+1];
		int step = 0;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=N;j++) fire[i][j] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fire[x][y].add(new Pair(x,y,m,s,d));
		}
		
		while(K-->0) { // K번 명령
			move();
		}
		
		int sum = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(fire[i][j].size()>0) {
					for(Pair a : fire[i][j]) {
						sum += a.m;
					}
				}
			}
		}

		System.out.println(sum);
	}
	
	static void move() {
		
		ArrayList<Pair> next[][] = new ArrayList[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) next[i][j] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(fire[i][j].size()>0) {
					for(Pair order : fire[i][j]) {
						int dir = order.dir;
						int speed = order.speed;
						int nx = order.x;
						int ny = order.y;
						for(int k=0;k<speed;k++) {
							nx += dx[dir];
							ny += dy[dir];
							if(nx<=0) nx = N;
							if(ny<=0) ny = N;
							if(nx>=N+1) nx=1;
							if(ny>=N+1) ny=1;
						}
						next[nx][ny].add(new Pair(nx,ny,order.m, speed, dir));
					}
				}
			}
		}
		
		fire = next;
		makeOne();
	}
	static void makeOne() {
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(fire[i][j].size()>=2) {
					int nx = i;
					int ny = j;
					int mSum = 0;
					int speedSum = 0;
					boolean odd = true; // 홀수
					boolean even = true; // 짝수
					for(Pair a : fire[nx][ny]) {
						mSum += a.m;
						speedSum += a.speed;
						if(a.dir%2==0) odd = false;
						else if(a.dir%2==1) even = false;
					}
					
					int s = speedSum / fire[nx][ny].size();
					fire[nx][ny].clear();
					if(mSum/5 > 0) {
						if(odd || even) { // 0 2 4 6
							for(int k=0;k<4;k++) {
								fire[nx][ny].add(new Pair(nx,ny,mSum/5, s, k*2));
							}
						}
						else { // 1 3 5 7
							for(int k=0;k<4;k++) {
								fire[nx][ny].add(new Pair(nx,ny,mSum/5, s, k*2+1));
							}
						}
					}
				}
			}
		}
		
	}

}
