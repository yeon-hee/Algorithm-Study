import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	
	static int N,S,array[],ans;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		array = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		if(S==0) ans--;
		System.out.println(ans);
	}
	
	static void subset(int index) {
		
		if(index==N) {
			
			int sum = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					sum += array[i];
				}
			}
			if(sum==S) ans++;
			return;
		}
		
		visited[index] = false;
		subset(index+1);
		visited[index] = true;
		subset(index+1);
		
	}

}
