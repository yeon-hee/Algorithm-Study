import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19952_인성문제있어 {
	
	static class Pair{
		int x; int y; int force;
		public Pair(int x, int y, int force) {
			this.x = x;
			this.y = y;
			this.force = force;
		}
	}
	
	static int N,M,O,F,SX,SY,AX,AY,array[][];
	static boolean check,visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken()); // 장애물 개수
			F = Integer.parseInt(st.nextToken()); // 초기 힘
			SX = Integer.parseInt(st.nextToken()); // 출발지
			SY = Integer.parseInt(st.nextToken());
			AX = Integer.parseInt(st.nextToken()); // 도착지
			AY = Integer.parseInt(st.nextToken());
			check = false;
			array = new int[N+1][M+1];
			visited = new boolean[N+1][M+1];
			
			for(int i=0;i<O;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int height = Integer.parseInt(st.nextToken());
				array[x][y] = height;
			}
			
			move();
			if(check) System.out.println("잘했어!!");
			else System.out.println("인성 문제있어??"); 
		}
		
		
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static void move() {
		
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(SX,SY,F));
		
		while(!queue.isEmpty()) {
			
			Pair current = queue.poll();
			int x = current.x;
			int y = current.y; // 현재 위치
			int force = current.force;
			
			if(x==AX && y==AY) {
				check = true;
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(0<nx && nx<=N && 0<ny && ny<=M && !visited[nx][ny]) {
					if(force <= 0) continue; // 남은 힘이 0이하인 경우 움직이지 못한다
					if(array[x][y] >= array[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Pair(nx,ny,force-1));
					}
					else {
						if(force >= (array[nx][ny] - array[x][y])) {
							visited[nx][ny] = true;
							queue.offer(new Pair(nx,ny,force-1));
						}
					}
				}
			}
		}
	}
}
