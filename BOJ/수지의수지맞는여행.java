import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수지의수지맞는여행 {
	
	static int R,C,ans;
	static char array[][];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			array = new char[R][C];
			visited = new boolean[26];
			ans = Integer.MIN_VALUE;
			
			for(int i=0;i<R;i++) {
				String str = br.readLine();
				for(int j=0;j<C;j++) {
					array[i][j] = str.charAt(j);
				}
			}
			
			visited[array[0][0]-'A'] = true;
			dfs(0,0,1);
			
			System.out.println("#"+testcase+" "+ans);
		}
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static void dfs(int x, int y, int cnt) {
		
		ans = Math.max(ans, cnt);
		if(ans==26) return;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<R && 0<=ny && ny<C && !visited[array[nx][ny]-'A']) {
				visited[array[nx][ny]-'A'] = true;
				dfs(nx,ny,cnt+1);
				visited[array[nx][ny]-'A'] = false;
			}
		}
	}

}
