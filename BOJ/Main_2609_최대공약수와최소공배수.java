import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int max = Math.max(num1, num2);
		int min = Math.min(num2, num1);
		
		while(min > 0) {
			int temp = max;
			max = min;
			min = temp % min;
		}
		
		System.out.println(max);
		System.out.println(num1 * num2 / max);
	}

}
