import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전0 {
	static int N,K,array[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N];
		int result = 0;
		
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			array[i] = n;
		}
		
		
		for(int i=N-1;i>=0;i--) {
			if(K==0) break;
			if(array[i] <= K) {
				int num = K/array[i];
				result += num;
				K -= (num*array[i]);
			}
		}
		
		System.out.println(result);
	}

}
