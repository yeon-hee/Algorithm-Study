import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19539_사과나무 {
	
	static int N,sum,sum2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			sum2 += num/2;
		}
		
		if(sum%3 == 0) {
			if(sum2 >= sum/3) System.out.println("YES");
			else System.out.println("NO");
		}
		else System.out.println("NO");
		
	}

}
