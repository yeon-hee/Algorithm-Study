import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
	
	static int N,M,array[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[M];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			int leftMax = array[i];
			int rightMax = array[i];
			
			for(int j=0;j<i;j++) {
				if(array[j] > array[i]) {
					leftMax = Math.max(leftMax, array[j]);
				}
			}
			for(int j=i+1;j<M;j++) {
				if(array[j] > array[i]) {
					rightMax = Math.max(rightMax, array[j]);
				}
			}
			
			int min = Math.min(leftMax, rightMax);
			if(min > array[i]) {
				answer += (min - array[i]);
			}
		}
		
		System.out.println(answer);
	}

}
