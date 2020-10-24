import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11005_진법변환2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		ArrayList<Character> list = new ArrayList<>();
		
		while(N>0) {
			
			int remainder = N%B;
			if(remainder <10) { // 9 이하라면 아스키코드값 0 더해서 char로 저장
				list.add((char)(remainder + '0'));
			}
			else { // 10 이상이라면 10을 빼고 아스키코드 값  'A'를 더해서 char로 저장
				list.add((char)(remainder - 10 + 'A'));
			}
			N /= B;
		}
		
		for(int i=list.size()-1;i>=0;i--) {
			System.out.print(list.get(i));
		}
		
	}

}
