import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N,array[][];
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		subset(0,0);
		System.out.println(min);
	}
	
	static void subset(int index, int cnt) {
		
		if(index==N/2) {
			
			calculation();
			return;
		}
		
		for(int i=cnt;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				subset(index+1,i+1);
				visited[i] = false;
			}
		}
	}
	
	static void calculation() {
		
		int one = 0;
		int two = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(!visited[i] && !visited[j]) one += array[i][j];
				else if(visited[i] && visited[j])two += array[i][j];
			}
		}

		min = Math.min(min, Math.abs(one-two));
	}

}
