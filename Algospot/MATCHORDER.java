import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MATCHORDER {
	
	static int russia[],korea[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++) {
			
			int N = Integer.parseInt(br.readLine()); // 선수 
			russia = new int[N];
			korea = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) russia[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) korea[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(russia);
			Arrays.sort(korea);
			
			int index = 0;
			int answer = 0;
			int i = 0;
			while(true) {
				if(i==N || index==N) break;
				if(russia[i] <= korea[index]) {
					i++;
					answer++;
				}
				index++;
			}
			
			
			System.out.println(answer);
		}
	}
}
