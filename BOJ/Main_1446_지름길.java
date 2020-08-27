import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1446_지름길 {
	
	static int N,D,input[][],result[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		input = new int[N][3];
		result = new int[D+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=D;i++) {
			int dis = result[i-1] + 1;
			for(int j=0;j<N;j++) {
				if(input[j][1]==i) { // 도착지가 현재 위치라면
					dis = Math.min(dis, result[input[j][0]]+input[j][2]);
				}
			}
			result[i] = dis;
		}
		
		System.out.println(result[D]);
	}
}
