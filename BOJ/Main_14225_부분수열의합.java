import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14225_부분수열의합 {
	
	static int N,array[];
	static boolean visited[],result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		array = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
			max += array[i];
		}
		
		result = new boolean[max+2];
		subset(0);
		
		for(int i=1;i<=max+1;i++) {
			if(!result[i]) {
				System.out.println(i);
				return;
			}
		}
	}
	
	static void subset(int index) {
		
		if(index==N) {
			
			int sum = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) sum += array[i];
			}
			
			result[sum] = true;
			return;
		}
		
		visited[index] = false;
		subset(index+1);
		visited[index] = true;
		subset(index+1);
	}

}
