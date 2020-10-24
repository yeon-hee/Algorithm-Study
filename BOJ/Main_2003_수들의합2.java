import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int array[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int j=i;j<N;j++) {
				sum += array[j];
				if(sum > M) break;
				else if(sum == M) {
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
