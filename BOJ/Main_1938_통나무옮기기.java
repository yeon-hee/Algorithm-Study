import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1938_통나무옮기기 {
	
	static class Pair{
		int x; int y; int dist; int status;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Pair(int x, int y, int dist, int status) {
			this(x, y);
			this.dist = dist;
			this.status = status; // 가로:1 세로:2
		}
	}
	
	static int N,ax,ay,ans,result;
	static char array[][];
	static boolean visited[][][];
	static ArrayList<Pair> list;
	static ArrayList<Pair> tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new char[N][N];
		visited = new boolean[N][N][3];
		
		list = new ArrayList<Pair>();
		tree = new ArrayList<Pair>();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				array[i][j] = str.charAt(j);
				if(array[i][j]=='E') list.add(new Pair(i,j));
				else if(array[i][j]=='B') tree.add(new Pair(i,j));
			}
		}
		
		ax = list.get(1).x;
		ay = list.get(1).y;
		
		if(ax==list.get(0).x) result = 1;
		else result = 2;
		
		bfs();
		
		System.out.println(ans);
	}
	
	static int dx[] = {-1,-1,-1,1,1,1,0,0};
	static int dy[] = {-1,0,1,-1,0,1,-1,1};
	static void bfs() {
		
		Queue<Pair> queue = new LinkedList<Pair>();
		int x = tree.get(1).x;
		int y = tree.get(1).y;
		if(x==tree.get(0).x) {
			visited[x][y][1] = true;
			queue.offer(new Pair(x,y,0,1)); // 가로-1
		}
		else {
			visited[x][y][2] = true;
			queue.offer(new Pair(x,y,0,2)); // 세로-2
		}
		
		
		O:while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			x = current.x;
			y = current.y;
			int dist = current.dist;
			int status = current.status;
			
			if(x==ax && y==ay) {
				ans = dist;
				if(status!=result) { // 돌 수 있는 자리인지 확인하기
					for(int j=0;j<8;j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue O;
					}
					ans++;
				}
				return;
			}
			
			L:for(int i=0;i<5;i++) {
				int nx = 0;
				int ny = 0;
				if(status==1) {
					if(i==0) { // 상
						for(int j=0;j<3;j++) {
							nx = x + dx[j];
							ny = y + dy[j];
							if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						}
						if(!visited[x+dx[1]][y+dy[1]][status]) visited[x+dx[1]][y+dy[1]][status] = true;
						else continue L;
						queue.offer(new Pair(x+dx[1],y+dy[1],dist+1,status));
					}
					else if(i==1) { // 하
						for(int j=3;j<6;j++) {
							nx = x + dx[j];
							ny = y + dy[j];
							if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						}
						if(!visited[x+dx[4]][y+dy[4]][status]) visited[x+dx[4]][y+dy[4]][status] = true;
						else continue L;
						queue.offer(new Pair(x+dx[4],y+dy[4],dist+1,status));
					}
					else if(i==2) { // 좌
						nx = x + dx[6]*2;
						ny = y + dy[6]*2;
						if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						if(!visited[x + dx[6]][y + dy[6]][status]) visited[x + dx[6]][y + dy[6]][status] = true;
						else continue L;
						queue.offer(new Pair(x + dx[6],y + dy[6],dist+1,status));
					}
					else if(i==3) { // 우
						nx = x + dx[7]*2;
						ny = y + dy[7]*2;
						if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						if(!visited[x + dx[7]][y + dy[7]][status]) visited[x + dx[7]][y + dy[7]][status] = true;
						else continue L;
						queue.offer(new Pair(x + dx[7],y + dy[7],dist+1,status));
					}
					else { // 회전
						for(int j=0;j<8;j++) {
							nx = x + dx[j];
							ny = y + dy[j];
							if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						}
						if(!visited[x][y][2]) visited[x][y][2] = true;
						else continue L;
						queue.offer(new Pair(x,y,dist+1,2));
					}
				}
				else { // 세로 일때 
					if(i==0) { // 상
						nx = x + dx[1]*2;
						ny = y + dy[1]*2;
						if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						if(!visited[x + dx[1]][y + dy[1]][status]) visited[x + dx[1]][y + dy[1]][status] = true;
						else continue L;
						queue.offer(new Pair(x + dx[1],y + dy[1],dist+1,status));
					}
					else if(i==1) { // 하
						nx = x + dx[4]*2;
						ny = y + dy[4]*2;
						if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						if(!visited[x + dx[4]][y + dy[4]][status]) visited[x + dx[4]][y + dy[4]][status] = true;
						else continue L;
						queue.offer(new Pair(x + dx[4],y + dy[4],dist+1,status));
					}
					else if(i==2) { // 좌
						for(int j=0;j<=6;j+=3) {
							nx = x + dx[j];
							ny = y + dy[j];
							if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						}
						if(!visited[x+dx[6]][y+dy[6]][status]) visited[x+dx[6]][y+dy[6]][status] = true;
						else continue L;
						queue.offer(new Pair(x+dx[6],y+dy[6],dist+1,status));
					}
					else if(i==3) { // 우
						for(int j=2;j<=7;j+=3) {
							nx = x + dx[j];
							ny = y + dy[j];
							if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
							if(j==5) j--;
						}
						if(!visited[x+dx[7]][y+dy[7]][status]) visited[x+dx[7]][y+dy[7]][status] = true;
						else continue L;
						queue.offer(new Pair(x+dx[7],y+dy[7],dist+1,status));
					}
					else { // 회전
						for(int j=0;j<8;j++) {
							nx = x + dx[j];
							ny = y + dy[j];
							if(nx<0 || nx>=N || ny<0 || ny>=N || array[nx][ny]=='1') continue L;
						}
						if(!visited[x][y][1]) visited[x][y][1] = true;
						else continue L;
						queue.offer(new Pair(x,y,dist+1,1));
					}
				}
			}
		}
	}

}
