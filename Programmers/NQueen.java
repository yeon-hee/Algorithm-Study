
public class NQueen {
	
	public static void main(String[] args) {
		
		int result = solution(4);
		System.out.println(result);
	}

	static int N,array[][],answer;
	static int solution(int n) {
        N = n;
        
        array = new int[n][n];
        for(int i=0;i<n;i++) dfs(i);
        return answer;
    }
	
	static void dfs(int x) {
		
		if(x==N) {
			
			for(int i=0;i<N;i++) {
				int count = 0;
				for(int j=0;j<N;j++) {
					if(array[i][j]==1) count++;
				}
				if(count!=1) return;
			}
			
			answer++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(check(x,i)) {
				array[x][i] = 1;
				dfs(x+1);
				array[x][i] = 0;
			}
		}
	}
	
	static int dx[] = {-1,1,1,-1};
	static int dy[] = {1,1,-1,-1};
	static boolean check(int x, int y) {
		
		for(int i=0;i<N;i++) { // 가로, 세로
			if(array[x][i]==1) return false;
			if(array[i][y]==1) return false;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x;
			int ny = y;
			while(true) {
				nx += dx[i];
				ny += dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					if(array[nx][ny]==1) return false;
				}
				else break;
			}
		}
		return true;
	}
}
