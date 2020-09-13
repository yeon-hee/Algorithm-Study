import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2026_소풍 {
	static int K,N,F,result[];
	static boolean visited[],check;
	static int list[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		list = new int[N+1][N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		
		for(int i=0;i<F;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a][b] = 1;
			list[b][a] = 1;
		}
		
		for(int i=1;i<=N;i++) {
			visited[i] = true;
			result[0] = i;
			dfs(i,1);
			if(check) break;
		}
		
		if(check) {
			for(int i=0;i<K;i++) System.out.println(result[i]);
		}
		else System.out.println(-1);
	}
	
	static void dfs(int x, int index) {
		
		if(check) return;
		if(index==K) {
			check = true;
			return;
		}
		
		for(int i=x+1;i<=N;i++) {
			// x는 현재, i는 다음 친구 목록
			if(list[x][i]==0) continue;
			
			int j = 0;
			for(j=0;j<index;j++) {
				if(list[i][result[j]]==0) break;
			}
			if(j!=index) continue;
			
			if(check) return;
			result[index] = i;
			dfs(i,index+1);
		}
		
	}

}
