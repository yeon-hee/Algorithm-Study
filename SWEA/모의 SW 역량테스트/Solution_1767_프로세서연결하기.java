import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 프로세서연결하기 {
	
	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,T,array[][],result,max;
	static boolean visited[][];
	static ArrayList<Pair> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			N = Integer.parseInt(br.readLine());
			array = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<>();
			result = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
					if(array[i][j]==1) {
						list.add(new Pair(i,j));
						visited[i][j] = true;
					}
				}
			}
			
			dfs(0,0,0);
			System.out.println("#"+testcase+" "+result);
		}
		
	}
	
	static int dx[] = {0,0,1,-1}; // 우, 좌, 하, 상
	static int dy[] = {1,-1,0,0};
	static void dfs(int index, int cnt, int sum) {
		
		if(index==list.size()) {
			if(max < cnt) {
				max = cnt;
				result = sum;
			}
			else if(max == cnt) {
				result = Math.min(result, sum);
			}
			return;
		}
		
		boolean check = false;
		Pair current = list.get(index);
		int x = current.x;
		int y = current.y;
		if(x==0 || x==N-1 || y==0 || y==N-1) dfs(index+1,cnt+1,sum);
		
		for(int i=0;i<4;i++) {
			if(check(x,y,i)) {
				check = true;
				int nx = x + dx[i];
				int ny = y + dy[i];
				int count = 0;
				count = visit(nx,ny,i,count,true);
				dfs(index+1,cnt+1,sum+count);
				nx = x + dx[i];
				ny = y + dy[i];
				visit(nx,ny,i,0,false);
			}
		}
		
		if(!check) dfs(index+1,cnt,sum);
	}
	
	static int visit(int nx, int ny, int i, int count, boolean isVisit) {
		
		while(true) {
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				visited[nx][ny] = isVisit;
				nx += dx[i];
				ny += dy[i];
				count++;
			}
			else break;
		}
		
		return count;
	}
	
	static boolean check(int x, int y, int dir) {
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		while(true) {
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				if(visited[nx][ny]) return false;
				else {
					nx += dx[dir];
					ny += dy[dir];
				}
			}
			else break;
		}
		
		return true;
	}
}
