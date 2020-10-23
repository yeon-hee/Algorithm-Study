import java.util.Arrays;

public class 방문길이 {

	static class Pair{
		int x; int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static int answer;
	static boolean visited[][][][];
	public int solution(String dirs) {

		visited = new boolean[11][11][11][11];
		
		dfs(5,5,0,dirs);
		return answer;
	}

	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static void dfs(int x, int y, int index, String dirs){

		if(index==dirs.length()) {
			return;
		}

		char dir = dirs.charAt(index);
		int direction = 0;

		if(dir=='L') direction = 2;
		else if(dir=='R') direction = 0;
		else if(dir=='U') direction = 3;
		else if(dir=='D') direction = 1;
		int nx = x + dx[direction];
		int ny = y + dy[direction];

		if(0<=nx && nx<11 && 0<=ny && ny<11){
			if(!visited[nx][ny][x][y]){
				visited[nx][ny][x][y] = true;
				visited[x][y][nx][ny] = true;
				answer++;
				dfs(nx,ny,index+1,dirs);
			}
			else dfs(nx,ny,index+1,dirs);
		}
		else dfs(x,y,index+1,dirs);
	}
}
