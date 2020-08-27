import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합 {
	static int N,array[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		int result = 0;
		int max = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			if(array[i]>0) sum += array[i];
			else {
				if(sum + array[i] > 0) {
					result = Math.max(result, sum);
					sum += array[i];
				} else {
					result = Math.max(result, sum);
					sum = 0;
				}
			}
			max = Math.max(max, array[i]);
		}
		
		result = Math.max(result, sum); // 마지막 수 
		if(result==0 && max<0) System.out.println(max);
		else System.out.println(result);
	}
}
